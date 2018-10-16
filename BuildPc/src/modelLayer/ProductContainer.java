
package modelLayer;

import java.util.ArrayList;

public class ProductContainer {
	private ArrayList<Motherboard> mths;
	private ArrayList<Cooler> coolers;
	private ArrayList<Cpu> cpus;
	private ArrayList<Hdd> hdds;
	private ArrayList<ExternDrive> extDrives;
	private ArrayList<OpticalDrive> optDrives;
	private ArrayList<Memory> rams;
	private ArrayList<GraphicsCard> gfxs;

	public ProductContainer(){
		mths = new ArrayList<Motherboard>();
		coolers = new ArrayList<Cooler>();
		cpus = new ArrayList<Cpu>();
		hdds = new ArrayList<Hdd>();
		extDrives = new ArrayList<ExternDrive>();
		optDrives = new ArrayList<OpticalDrive>();
		rams = new ArrayList<Memory>();
		gfxs = new ArrayList<GraphicsCard>();
		
		Motherboard mth = null;
		Memory mem = null;
		Cooler cooler = null;
		Cpu cpu = null;
		Hdd hdd = null;
		ExternDrive extDrive = null;
		OpticalDrive optDrive = null;
		GraphicsCard gfx = null;
		
		mths.add(mth);
		coolers.add(cooler);
		cpus.add(cpu);
		hdds.add(hdd);
		extDrives.add(extDrive);
		optDrives.add(optDrive);
		rams.add(mem);
		gfxs.add(gfx);
	}

	public ArrayList<Motherboard> getMths() {
		return mths;
	}

	public ArrayList<Cooler> getCoolers() {
		return coolers;
	}

	public ArrayList<Cpu> getCpus() {
		return cpus;
	}

	public ArrayList<Hdd> getHdds() {
		return hdds;
	}

	public ArrayList<ExternDrive> getExtDrives() {
		return extDrives;
	}

	public ArrayList<OpticalDrive> getOptDrives() {
		return optDrives;
	}

	public ArrayList<Memory> getRams() {
		return rams;
	}

	public ArrayList<GraphicsCard> getGfxs() {
		return gfxs;
	}
	
}
