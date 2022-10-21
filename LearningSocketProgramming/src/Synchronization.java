

class Printer {
    void printAssignment(Person p){
        System.out.println(p.name+"-->Printing started...");
        for(int i=0; i<p.pages; i++){
            System.out.println(p.name + "--> printed page#"+(i+1));
        }
        System.out.println(p.name+"-->Completed...");
    }
}

class Person implements Runnable {

    String name;
    final Printer printer;
    int pages;
    Thread t;

    Person(String name, Printer p, int pages){
        this.name= name;
        this.printer = p;
        this.pages = pages;
        t= new Thread(this, name);
        t.start();
    }


    @Override
    public void run() {
        synchronized (printer) {
            printer.printAssignment(this);
        }
    }
}


public class Synchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Person ashik = new Person("Ashik", printer, 5);
        Person tipu = new Person("Tipu", printer, 10);
        Person jannat = new Person("Jannat", printer, 8);
    }
}
