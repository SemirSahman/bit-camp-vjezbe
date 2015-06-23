package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public class ArrayManipulation {
	
	public static Computer[] extendArray(Computer[] c){
		
		Computer[] a = new Computer[c.length+1];
		
		for(int i = 0; i<c.length;i++){
			a[i] = c[i];
		}
		return a;
	}
	public static Computer[] shrinkArray(Computer[] c, int idx){
		int counter = 0;
		Computer[] a = new Computer[c.length-1];
		for(int i = 0;i<a.length;i++){
			if(counter == idx){
				counter++;
			}
			a[i]=c[counter];
			counter++;
			
		}
		return a;
	}

}




package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public class BusNetwork extends Network {

	public BusNetwork(String networkName) {
		super(networkName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addComputer(Computer c) {
		
		ArrayManipulation.extendArray(getCompArr());
		getCompArr()[getCompArr().length-1]=c;
		
		if(c instanceof Server){
			throw new UnsupportedOperationException("Cannot connect servers on this network");
		} else if (c instanceof Client) {
			Client c1 = (Client) c;
			
			c1.connect(this);
		}
		
	}

	@Override
	public void removeComputer(Computer c) {
		// TODO Auto-generated method stub
		
	}

}






package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public class Client extends Computer implements Connectable {

	private Computer compConnected;
	private Network netConnected;

	/**
	 * this method connects client to computer
	 */
	@Override
	public void connect(Computer c) {
		if (compConnected == null && netConnected == null) {
			compConnected = c;

		} else {
			throw new NullPointerException("Can't connect");
		}

	}

	/**
	 * this method connects client to network
	 */
	@Override
	public void connect(Network n) {
		if (compConnected == null && netConnected == null) {
			netConnected = n;

		} else {
			throw new NullPointerException("Can't connect");
		}

	}

	/**
	 * this method disconnects client from computer and network
	 */
	@Override
	public void disconnect() {
		compConnected = null;
		netConnected = null;

	}

	/**
	 * Client constructor
	 * 
	 * @param name
	 * @param macAddress
	 */
	public Client(String name, char[] macAddress) {
		super(name, macAddress);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (compConnected == null) {
			if (other.compConnected != null)
				return false;
		} else if (!compConnected.equals(other.compConnected))
			return false;
		if (netConnected == null) {
			if (other.netConnected != null)
				return false;
		} else if (!netConnected.equals(other.netConnected))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [compConnected=" + compConnected + ", netConnected="
				+ netConnected + "]";
	}

	/**
	 * getter
	 * 
	 * @return compConnected link
	 */
	public Computer getCompConnected() {
		return compConnected;
	}

	/**
	 * setter
	 * 
	 * @param compConnected
	 *            link
	 */
	public void setCompConnected(Computer compConnected) {
		this.compConnected = compConnected;
	}

	/**
	 * getter
	 * 
	 * @return netConnected link
	 */
	public Network getNetConnected() {
		return netConnected;
	}

	/**
	 * setter
	 * 
	 * @param netConnected
	 *            link
	 */
	public void setNetConnected(Network netConnected) {
		this.netConnected = netConnected;
	}

}






package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public abstract class Computer {

	private String name;
	private MACAddress macAddress;

	/**
	 * Computer class constructor
	 * 
	 * @param name
	 *            Computer name
	 * @param macAddress
	 *            Mac address
	 */
	public Computer(String name, char[] macAddress) {
		super();
		this.name = name;
		this.macAddress = new MACAddress(macAddress);
	}

	/**
	 * Constructor
	 */
	public Computer() {
		super();
		this.name = "Computer";

		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b' };
		this.macAddress = new MACAddress(arr);
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", macAddress=" + macAddress + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (macAddress == null) {
			if (other.macAddress != null)
				return false;
		} else if (!macAddress.equals(other.macAddress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * getter
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter
	 * 
	 * @param name
	 *            you want to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter
	 * 
	 * @return Mac address
	 */
	public MACAddress getMacAddress() {
		return macAddress;
	}

	/**
	 * setter
	 * 
	 * @param macAddress
	 *            you want to set
	 */
	public void setMacAddress(MACAddress macAddress) {
		this.macAddress = macAddress;
	}

	// inner class
	public class MACAddress {

		char[] address; // 0123456789ab

		public MACAddress(char[] address) {
			this.address = address;
		}

		@Override
		// 01:23:45:67:89:ab
		public String toString() {
			String s = "";
			for (int i = 0; i < address.length; i++) {
				if (i % 2 == 0 && i != 0) {
					s += ":";
				}
				s += address[i];
			}

			return s;

		}

	}

}





package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public interface Connectable {
	/**
	 * this method connects client to computer
	 * 
	 * @param c
	 *            computer to which you want to connect
	 */
	void connect(Computer c);

	/**
	 * this method connects client to network
	 * 
	 * @param n
	 *            network to which you want to connect
	 */
	void connect(Network n);

	/**
	 * this method disconnects client from computer and network
	 */
	void disconnect();

}




package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public interface Functionable {
	
	boolean isFunctionable();

}







package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public class Main {
	
	public static void main(String[] args) {

		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
		'b' };
		Computer c = new Computer() {
			
		};
		Network n = new Network("Mreza") {
			
			@Override
			public void removeComputer(Computer c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addComputer(Computer c) {
				// TODO Auto-generated method stub
				
			}
		};
		
		Server s = new Server("Server", arr, 10);
		Client cl = new Client("Mase zna se", arr);
		cl.connect(c);
		cl.disconnect();
		cl.connect(n);
		
		
	}

}







package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public abstract class Network {

	private String networkName;
	private Computer[] compArr;

	/**
	 * Network constructor
	 * 
	 * @param networkName
	 */
	public Network(String networkName) {
		super();
		this.networkName = networkName;
		this.compArr = new Computer[0];
	}

	/**
	 * This method adds computer
	 * 
	 * @param c
	 *            computer you want to add
	 */
	public abstract void addComputer(Computer c);

	/**
	 * This method removes computer
	 * 
	 * @param c
	 *            computer you want to remove
	 */
	public abstract void removeComputer(Computer c);

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public Computer[] getCompArr() {
		return compArr;
	}

	public void setCompArr(Computer[] compArr) {
		this.compArr = compArr;
	}
	
	

}





package ba.bitcamp.week6.day2.ObjectOrientedProgramming;

public class Server extends Computer {

	private int max;

	/**
	 * getter
	 * 
	 * @return max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * setter
	 * 
	 * @param max
	 *            you want to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * Server constructor
	 * 
	 * @param name
	 * @param macAddress
	 * @param max
	 */
	public Server(String name, char[] macAddress, int max) {
		super(name, macAddress);
		this.max = max;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (max != other.max)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Server [max=" + max + "]";
	}

}

