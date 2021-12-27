import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Elements.*;
import algoDiffusion.*;

public class Tests {
	private Scheduler scheduler;
	private ObserverDeCapteur afficheur1;
    private ObserverDeCapteur afficheur2;
    private ObserverDeCapteur afficheur3;
    private ObserverDeCapteur afficheur4;

    @BeforeEach
    public void generateAfficheur()
    {
    	this.scheduler=new Scheduler(8L);
        this.afficheur1 = new Afficheur();
        this.afficheur2 = new Afficheur();
        this.afficheur3 = new Afficheur();
        this.afficheur4 = new Afficheur();
    }

    @Test
    void Algorithme_Atomique() throws InterruptedException
    {
    	AlgorithmeDiffusion algo= new DiffusionAtomique();
		CapteurImpl capteur=new CapteurImpl(algo);
		
		capteur.attach(new Canal(capteur,scheduler,afficheur1));
		capteur.attach(new Canal(capteur,scheduler,afficheur2));
		capteur.attach(new Canal(capteur,scheduler,afficheur3));
		capteur.attach(new Canal(capteur,scheduler,afficheur4));
		
        algo.configure(capteur);
        
        int numbTick = 6;
        for (int i = 0; i < numbTick; ++i)
        {
            capteur.tick();
        }
        
        scheduler.waitAndFinished();
        
        List<Integer> data1 = this.afficheur1.getValues();
        List<Integer> data2 = this.afficheur2.getValues();
        List<Integer> data3 = this.afficheur3.getValues();
        List<Integer> data4 = this.afficheur4.getValues();

        //ici, on verifie que chaque afficheur ai toutes les valeurs et dans l'ordre
        for (int i = 0; i < numbTick; ++i)
        {
            assertEquals(data1.get(i), i+1);
            assertEquals(data2.get(i), i+1);
            assertEquals(data3.get(i), i+1);
            assertEquals(data4.get(i), i+1);
        }
    }
    
    @Test
    void Algorithme_Sequentielle() throws InterruptedException
    {
    	AlgorithmeDiffusion algo= new DiffusionSequentielle();
		CapteurImpl capteur=new CapteurImpl(algo);
		
		capteur.attach(new Canal(capteur,scheduler,afficheur1));
		capteur.attach(new Canal(capteur,scheduler,afficheur2));
		capteur.attach(new Canal(capteur,scheduler,afficheur3));
		capteur.attach(new Canal(capteur,scheduler,afficheur4));
		
        algo.configure(capteur);
        
        int numbTick = 6;
        for (int i = 0; i < numbTick; ++i)
        {
            capteur.tick();
        }
        
        scheduler.waitAndFinished();
        
        List<Integer> data1 = this.afficheur1.getValues();
        List<Integer> data2 = this.afficheur2.getValues();
        List<Integer> data3 = this.afficheur3.getValues();
        List<Integer> data4 = this.afficheur4.getValues();

        //d abord, on verifie qu ils aient la meme taille
        int length=data1.size();
        assertTrue(length == data2.size());
        assertTrue(length == data3.size());
        assertTrue(length == data4.size());
        
        //en suite on verifie que les afficheurs aient les memes elements.
        //En revanche, on ne verifie pas qu ils aient toutes les valeurs etant donnee que c est du sequentielle.
        for (int i = 0; i < length; ++i)
        {
            int value=data1.get(i);
            assertEquals(data2.get(i), value);
            assertEquals(data3.get(i), value);
            assertEquals(data4.get(i), value);
            
            //on verifie egalement que les valeurs soient dans l ordre croissant
            if(i>0) {
            	assertTrue(data1.get(i-1)<=value);
            }
        }
    }
    
    @Test
    void Algorithme_Epoque() throws InterruptedException
    {
    	AlgorithmeDiffusion algo= new DiffusionEpoque();
		CapteurImpl capteur=new CapteurImpl(algo);
		
		capteur.attach(new Canal(capteur,scheduler,afficheur1));
		capteur.attach(new Canal(capteur,scheduler,afficheur2));
		capteur.attach(new Canal(capteur,scheduler,afficheur3));
		capteur.attach(new Canal(capteur,scheduler,afficheur4));
		
        algo.configure(capteur);
        
        int numbTick = 6;
        for (int i = 0; i < numbTick; ++i)
        {
            capteur.tick();
        }
        
        scheduler.waitAndFinished();
        
        List<List<Integer>> datas = List.of(afficheur1.getValues(), afficheur2.getValues(),
        		afficheur3.getValues(), afficheur4.getValues());
        
        //On verifie juste que les elements soient dans l ordre croissant
        for(List<Integer> data : datas) {
	        for (int i = 1; i < data.size(); ++i)
	        {
	            assertTrue(data.get(i-1)<=data.get(i));
	        }
    	}
    }
}
