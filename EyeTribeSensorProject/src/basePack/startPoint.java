package basePack;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.GazeManager.ApiVersion;
import com.theeyetribe.client.GazeManager.ClientMode;

import commandPack.CommandAttribute;
import commandPack.Commands;
import commandPack.ScrollUp;
import dataPack.QueueOfFixationSets;



/**
 * 
 * Starting Point in the code which is the default thread.
 * From here, we do the following:<p>
 * 1. Get {@link com.theeyetribe.client.GazeManager} handler.<br>
 * 2. Check for its connection status.<br>
 * 3. Get a {@link dataPack.QueueOfFixationSets} handle.<br>
 * 4. Get {@link basePack.SensorDataProducer} handle by passing it handle from Part 3.<br>
 * 5. Get {@link basePack.SensorDataConsumer} handle by passing it handle from Part 3.<br>
 * 6. Make thread from the handle in Part 5. <br>
 * 7. Add a shutdown hook for the handle in Part 1.<br>
 * @version 1.0
 * 
 */
public class startPoint {

	public static void main(String[] args) {
		
		final GazeManager gm = GazeManager.getInstance();
        boolean success = gm.activate(ApiVersion.VERSION_1_0, ClientMode.PUSH);

		System.out.println("Hello, World! Activation: "+ success);
		
        
        QueueOfFixationSets queueOfFixationSets = new QueueOfFixationSets(25) ;
        

		final SensorDataProducer gazeProuducerListener = new SensorDataProducer(queueOfFixationSets) ;
        gm.addGazeListener(gazeProuducerListener);
        
        
        SensorDataConsumer sensorDataConsumer = new SensorDataConsumer(queueOfFixationSets) ;
        
        Thread consumerThread = new Thread(sensorDataConsumer) ;
        consumerThread.start();
        
        CommandAttribute cm = new ScrollUp(5) ;
        Commands c = new Commands("Scroll Up",cm) ;
       
        
        
        
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                gm.removeGazeListener(gazeProuducerListener);
             gm.deactivate();
            }
        });
        
	}
}
