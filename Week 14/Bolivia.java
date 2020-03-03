package ferrocarrilesDeAmericaDelSur.railways;

import ferrocarrilesDeAmericaDelSur.errors.RailwaySystemError;
import ferrocarrilesDeAmericaDelSur.errors.SetUpError;
import ferrocarrilesDeAmericaDelSur.tools.Clock;
import ferrocarrilesDeAmericaDelSur.tools.Delay;

/**
 * An implementation of a railway.  The runTrain method, should, in collaboration with Peru's runTrain(), guarantee
 * safe joint operation of the railways.
 *
 * @author Christian Harborow
 * @version February 2020
 */
public class Bolivia extends Railway {
	/**
     * Change the parameters of the Delay constructor in the call of the superconstructor to
	 * change the behaviour of this railway.
	 * @throws SetUpError if there is an error in setting up the delay.
	 */
	public Bolivia() throws SetUpError {
		super("Bolivia",new Delay(0.1,0.3));
	}

    /**
     * Run the train on the railway.
     * @throws RailwaySystemError
     */
    public void runTrain() throws RailwaySystemError {
    	Clock clock = getRailwaySystem().getClock();

    	while (!clock.timeOut()){
            choochoo();
            getBasket().putStone();

            while(getRailwaySystem().getNextRailway(this).getBasket().hasStone()){
                //within the shared (priority) basket 1 stone represents Bolivia and no stone represents Peru
                if (!getSharedBasket().hasStone()){
                    getBasket().takeStone();
                    while (!getSharedBasket().hasStone()){
                        siesta();
                    }
                    getBasket().putStone();
                }
                else {
                    siesta();
                }
            }

            crossPass();
            if (getSharedBasket().hasStone()){
                getSharedBasket().takeStone();
            }
            getBasket().takeStone();
        }
    }
}