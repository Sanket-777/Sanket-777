import java.util.Scanner;
class Info{
	public String accno;
    public String name;
    public long balance;
	public long tbalance;
	 Scanner KB = new Scanner(System.in);
	  //method to open an account
	void openAccount() {
		System.out.print("Enter Name: ");
        name = KB.nextLine();
        System.out.print("Enter Account No: ");
        accno = KB.next();
         System.out.print("Enter Balance: ");
        balance = KB.nextLong();
    }

    //method to display account details
    void showAccount() {
	 System.out.println("======================================================"  );
        System.out.println("Account Number:"+accno  );
	 System.out.println("Account Holder Name:"+name  );
	 System.out.println("Account Balance:"+balance  );
	 System.out.println("======================================================"  );
    }

}
 class Other extends Info {
  
//method to deposit money
    void deposit(int trans) {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
    }

	void deposit(long transmoney)
	{
		long amt;
        System.out.println("Confirm the Amount U Want to Deposit : ");
        amt = KB.nextLong();
        if(amt == transmoney){
            balance = balance + amt;
            System.out.println("Money has been transfered sucessfully");
        }
        else{
            System.out.println("Not verified money amount not same");
        }
    }

    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }
	//method to tranfer money
	long transfermoney()
	{
		long amt;
        System.out.println("Enter Amount U Want to transfer : ");
        amt = KB.nextLong();
		tbalance=amt;
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
			
        }
		return amt;	
	}
	void recievemoney(long transmoney)
	{
        deposit(transmoney);
	}
	

    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
interface Welcome{
	void Welcomenote();
	void ThankyouNote();	
}

public class Exbank implements Welcome{
	 public  void Welcomenote()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("---------Welcome To ExBank----------------------- ");
		                          
	}
	public void ThankyouNote()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("---------Thank You For using Ex-bank-------------");
		                          
	}
    public static void main(String arg[]) {
        Scanner KB = new  Scanner(System.in);
		Exbank T = new Exbank();
		
        
		T.Welcomenote();

        //create initial accounts
		
        System.out.print("How Many Customer U Want to Input : ");
        int n = KB.nextInt();
		Other C[] = new Other[n];
        for (int i = 0; i < C.length; i++) {
            System.out.print("Enter Information for Customer ");
			System.out.println(i+1);
            C[i] = new Other();
            C[i].openAccount();
			System.out.println("=================================================");
        }
        try
		{
        //run loop until menu 6 is not pressed
        int ch;
        do {
            System.out.println("-------------------Main Menu---------------------\n 1.Display All\n 2.Search By Account Number\n 3.Deposit\n 4.Withdrawal\n 5.Transfer\n 6.Exit \n-------------------------------------------------");
                System.out.println("Ur Choice :"); ch = KB.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
			     System.out.println("=======Customer "+(i+1)+"================"  );
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn = KB.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit(1);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Transaction Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Transaction Failed..Account Not Exist..");
                        }
                        break;
						
						
					case 5:
                        long transmoney=0;
					     System.out.print("Enter Senders Account No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                transmoney = C[i].transfermoney();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Transaction Failed..Account Not Exist..");
							break;
                        }
						System.out.print("Enter Recievers No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].recievemoney(transmoney);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Transaction Failed..Account Not Exist..");
                        }
                        break;
					    
							
					

                    case 6:
					    T.ThankyouNote();
                        System.out.println("...Visit Again.....");
                        break;
						
						
				    default:
					    System.out.println("-------------------Invalid input-------------");
						break;
                }
           
		}
            while (ch != 6);
        }
		catch(Exception e)
		{
			System.out.println(e);
		}
    }
	
}
