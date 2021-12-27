package algoDiffusion;

import Elements.Capteur;

/**
 * <b>Represents the diffusion algorithm</b>
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */
public interface AlgorithmeDiffusion {

	/**
	 * Allows to configure the diffusion algorithm by injecting a sensor.
	 *
	 * @param c is a Capteur (the sensor) (not null)
	 *
	 * @throws NullPointerException if the c is null
	 */
	void configure(Capteur c);

	/**
	 * Starts the execution of the algorithm.
	 *
	 * The capteur must not be null
	 *
	 * @throws NullPointerException if the capteur is null
	 * @throws InterruptedException if the thread is waiting for a token and an interrupt signal will be thrown
	 */

	void diffuse() throws InterruptedException;

	/**
	 * Allows to release a token on the semaphore. It is used by the sensor.
	 *
	 * @throws NullPointerException if the semaphore is null
	 */
	void releaseSemaphore();
}
