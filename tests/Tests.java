import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Elements.*;
import algoDiffusion.*;

public class Tests {
	private ObserverDeCapteur afficheur1;
    private ObserverDeCapteur afficheur2;
    private ObserverDeCapteur afficheur3;
    private ObserverDeCapteur afficheur4;

    //@BeforeEach
    public void generateAfficheur()
    {
        this.afficheur1 = new Afficheur();
        this.afficheur2 = new Afficheur();
        this.afficheur3 = new Afficheur();
        this.afficheur4 = new Afficheur();
    }

    //@Test
    //@DisplayName("Test oracle algorithme atomique")
    void Oracle_Algorithme_Atomique() throws InterruptedException
    {
       
        /*AlgorithmeDiffusion algorithmeDiffusion = new DiffusionAtomique();
        Capteur capteur = CapteurImpl.create(algorithmeDiffusion);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8);
        ObserverDeCapteurAsync canal1 = CanalImpl.create(scheduledExecutorService, this.afficheur1);
        ObserverDeCapteurAsync canal2 = CanalImpl.create(scheduledExecutorService, this.afficheur2);
        ObserverDeCapteurAsync canal3 = CanalImpl.create(scheduledExecutorService, this.afficheur3);
        ObserverDeCapteurAsync canal4 = CanalImpl.create(scheduledExecutorService, this.afficheur4);
        capteur.attach(canal1);
        capteur.attach(canal2);
        capteur.attach(canal3);
        capteur.attach(canal4);
        algorithmeDiffusion.configure(capteur);
        int tickNumber = 7;

        for (int i = 0; i < tickNumber; ++i)
        {
            capteur.tick();
        }
        scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        int minimumDataCount = minimumDataCountAfficheurs(
                List.of(this.afficheur1, this.afficheur2, this.afficheur3, this.afficheur4));
        List<Integer> dataAfficheur1 = this.afficheur1.getData();
        List<Integer> dataAfficheur2 = this.afficheur1.getData();
        List<Integer> dataAfficheur3 = this.afficheur1.getData();
        List<Integer> dataAfficheur4 = this.afficheur1.getData();
        // Au cas ou le capteur ne commence pas a 0
        int firstValue = dataAfficheur1.get(0);

        for (int i = 0; i < minimumDataCount; ++i)
        {
            assertEquals(dataAfficheur1.get(i), firstValue + i);
            assertEquals(dataAfficheur2.get(i), firstValue + i);
            assertEquals(dataAfficheur3.get(i), firstValue + i);
            assertEquals(dataAfficheur4.get(i), firstValue + i);
        }
        displayAfficheursDatas(List.of(dataAfficheur1, dataAfficheur2, dataAfficheur3, dataAfficheur4),
                minimumDataCount);*/
    }
}
