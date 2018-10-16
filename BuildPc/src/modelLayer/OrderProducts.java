package modelLayer;

public class OrderProducts {
	private Cpu cpu;
	private Cooler cooler;
	private ExternDrive extDrive;
	private OpticalDrive optDrive;
	private Hdd hdd;
	private Motherboard mth;
	private Memory mem;
	private GraphicsCard gfx;
	
	public OrderProducts(){
		
	}
	public OrderProducts(Cpu cpu, Cooler cooler, ExternDrive extDrive, OpticalDrive optDrive,
			             Hdd hdd, Motherboard mth, Memory mem, GraphicsCard gfx){
		this.cpu = cpu;
		this.cooler = cooler;
		this.extDrive = extDrive;
		this.optDrive = optDrive;
		this.mem = mem;
		this.hdd = hdd;
		this.mth = mth;
		this.gfx = gfx;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public Cooler getCooler() {
		return cooler;
	}
	public void setCooler(Cooler cooler) {
		this.cooler = cooler;
	}
	public ExternDrive getExtDrive() {
		return extDrive;
	}
	public void setExtDrive(ExternDrive extDrive) {
		this.extDrive = extDrive;
	}
	public OpticalDrive getOptDrive() {
		return optDrive;
	}
	public void setOptDrive(OpticalDrive optDrive) {
		this.optDrive = optDrive;
	}
	public Hdd getHdd() {
		return hdd;
	}
	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}
	public Motherboard getMth() {
		return mth;
	}
	public void setMth(Motherboard mth) {
		this.mth = mth;
	}
	public Memory getMem() {
		return mem;
	}
	public void setMem(Memory mem) {
		this.mem = mem;
	}
	public GraphicsCard getGfx() {
		return gfx;
	}
	public void setGfx(GraphicsCard gfx) {
		this.gfx = gfx;
	}

	
}
