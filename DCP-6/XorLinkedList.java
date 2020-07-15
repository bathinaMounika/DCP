import java.util.LinkedList;
import java.util.Scanner;

public class XorLinkedList{

	LinkedList<Node> memory;
    int rIndex; //address of the root in memory[]
    //root node present at index 0 in XLL
    //root node might present at any address in the memory

	XorLinkedList(){
		this.memory = new LinkedList<Node>();
		rIndex = 1;
		int val[] = {23, 40, 98, 0, 39};
		int both[] = {6, -5, 3, -3, 1};
		for(int i=0; i < val.length; i++){
			Node node = new Node(val[i], both[i]);
			this.memory.add(node);
		}
	}

	static class Node{
		int val;  
		int both; //nextAddr ^ prevAddr

		Node(int val, int both){
			this.val = val;
			this.both = both;
		}
	}

	public void add(int val){ //add to the end of XLL
		Node newNode = new Node(val, -1);
		this.memory.add(newNode);
		//traverse the XLL & append n to it.
		Node curr = this.memory.get(this.rIndex);
		int prevAddr = -1;
		int nextAddr = curr.both ^ -1;
		while(nextAddr >= 0){
			prevAddr = this.memory.indexOf(curr);
		    curr = this.memory.get(nextAddr);
		    nextAddr = prevAddr ^ curr.both;
		}//ends when curr points to the last node in the XLL
		curr.both = prevAddr ^ this.memory.indexOf(newNode);
	}

	public Node get(int index){ //returns node at index in XorLL

		if(index == 0){ //returns root
			return this.memory.get(this.rIndex);
		}
		if(index >= this.memory.size())
			return null;
		int i = 0;
		Node root = this.memory.get(this.rIndex);
		Node curNode = root;
		int prevAddr = -1;
		Node nextNode;
		while(i < index ){
			if(curNode.both < 0){ // means root is the curNode
				nextNode = this.memory.get(curNode.both ^ -1); 
			}
			else{
				nextNode = this.memory.get(prevAddr ^ curNode.both);
			}
			prevAddr = this.memory.indexOf(curNode);
			curNode = nextNode;
			i++;
		}
		if(i == index){
			return curNode;
		}
		return null;		
	}

	public void print(){
		Node curr = this.memory.get(this.rIndex);
		int prevAddr = -1;
		int nextAddr = curr.both ^ prevAddr;
		while(nextAddr >=0){
			System.out.println("value: "+curr.val);
			prevAddr = this.memory.indexOf(curr);
			curr = this.memory.get(nextAddr);
			nextAddr = prevAddr ^ curr.both;
		}
		System.out.println("value: ",curr.val);
	}


	public static void main(String[] args){
		XorLinkedList xll = new XorLinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("XorLinkedList has "+ xll.memory.size() + " elements");
		System.out.println("Type the number from below:\n1. print all elements \n2. to get(int index) element at index\n3. add(int val)\n4.To exit");
		int input = sc.nextInt();
		while(true){
			switch(input){
				case 1: 
				    xll.print();
				    break;
				case 2:
					System.out.println("enter index to get the node's 'val' and 'both' entries");
					Node node = xll.get(sc.nextInt());
					if(node != null)
						System.out.println("node has val: "+node.val + "& both: "+ node.both);
					else
						System.out.println("Sorry the XORLL has " + xll.memory.size() + "elements. index starts at 0(Zero)" );
					break;
				case 3:
					System.out.println("Which number you wants to add?");
					xll.add(sc.nextInt());
					break;
				case 4:
					System.exit(0);
			}
			System.out.println("choose 1, 2, 3, 4");
			input = sc.nextInt();
		}		
	}
}