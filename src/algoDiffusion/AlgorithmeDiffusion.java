package algoDiffusion;

import Elements.Capteur;

public interface AlgorithmeDiffusion {

	void configure(Capteur c);
	void diffuse() throws InterruptedException;
	void releaseSemaphore();
}
