package controller;

import java.util.ArrayList;

import modelLayer.*;

public class ProductController {
	private ProductContainer prodCont;
	
	public ProductController(){
		prodCont = new ProductContainer();
	}
	
	public ArrayList<Cpu> getCpus(){
	 return	prodCont.getCpus();
	}
	
	public ArrayList<Cooler> getCoolers(){
		return prodCont.getCoolers();
	}
	
    public ArrayList<ExternDrive> getExtDrive(){
    	return prodCont.getExtDrives();
    }
    
    public ArrayList<GraphicsCard> getGfx(){
    	return prodCont.getGfxs();    	
    }
    
    public ArrayList<OpticalDrive> getOptDrive(){
    	return prodCont.getOptDrives();
    }
    
    public ArrayList<Hdd> getHdds(){
    	return prodCont.getHdds();
    }
    
    public ArrayList<Motherboard> getMths(){
    	return prodCont.getMths();
    }
    
    public ArrayList<Memory> getMem(){
    	return prodCont.getRams();
    }
    
    public Motherboard readMth(String socket) throws Exception {
    	Motherboard
    }
    
}
