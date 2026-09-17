package Assignment12;

import java.util.Scanner;

class TicketPool {
    private int availableTickets;

    public TicketPool(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public synchronized boolean sellTicket(String counterName) {
        if (availableTickets > 0) {
            availableTickets--;
            System.out.println(counterName + " sold ticket. Remaining: " + availableTickets);
            return true;
        }
        return false;
    }

    public synchronized int getAvailableTickets() {
        return availableTickets;
    }

    public synchronized void reset(int totalTickets) {
        this.availableTickets = totalTickets;
    }
}

class CounterThread extends Thread {
    private final TicketPool pool;

    public CounterThread(String name, TicketPool pool) {
        super(name);
        this.pool = pool;
    }

    @Override
    public void run() {
        while (pool.sellTicket(getName())) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
                break;
            }
        }
    }
}

class CounterRunnable implements Runnable {
    private final String name;
    private final TicketPool pool;

    public CounterRunnable(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {
        while (pool.sellTicket(name)) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
                break;
            }
        }
    }
}

public class Assignment12 {
    private static final TicketPool pool = new TicketPool(10);
    private static CounterThread counterA = null;
    private static Thread counterB = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n===== Multi-Counter Ticket Booking Simulator =====\n"
                    + "1. Start Counter using Thread Class\n"
                    + "2. Start Counter using Runnable Interface\n"
                    + "3. Set Thread Priority\n"
                    + "4. Display Thread Status\n"
                    + "5. Display Available Tickets\n"
                    + "6. Wait for All Counters to Finish\n"
                    + "7. Reset Ticket Pool\n"
                    + "8. Exit");
            System.out.print("Enter your choice: ");

            try {
                String input = sc.nextLine().trim();
                if (input.isEmpty()) continue;
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        if (counterA != null && counterA.isAlive()) {
                            System.out.println("Counter-A is already running.");
                        } else {
                            counterA = new CounterThread("Counter-A", pool);
                            System.out.println("Starting Counter-A (Thread class)...");
                            counterA.start();
                        }
                        break;

                    case 2:
                        if (counterB != null && counterB.isAlive()) {
                            System.out.println("Counter-B is already running.");
                        } else {
                            counterB = new Thread(new CounterRunnable("Counter-B", pool), "Counter-B");
                            System.out.println("Starting Counter-B (Runnable interface)...");
                            counterB.start();
                        }
                        break;

                    case 3:
                        System.out.print("Enter counter (A or B): ");
                        String counter = sc.nextLine().trim().toUpperCase();
                        System.out.print("Enter priority (1-10): ");
                        int prio = Integer.parseInt(sc.nextLine().trim());

                        if (prio < Thread.MIN_PRIORITY || prio > Thread.MAX_PRIORITY) {
                            System.out.println("Invalid priority! Must be between 1 and 10.");
                            break;
                        }

                        if ("A".equals(counter)) {
                            if (counterA == null) counterA = new CounterThread("Counter-A", pool);
                            counterA.setPriority(prio);
                            System.out.println("Counter-A priority set to " + prio);
                        } else if ("B".equals(counter)) {
                            if (counterB == null) counterB = new Thread(new CounterRunnable("Counter-B", pool), "Counter-B");
                            counterB.setPriority(prio);
                            System.out.println("Counter-B priority set to " + prio);
                        } else {
                            System.out.println("Invalid counter choice! Choose A or B.");
                        }
                        break;

                    case 4:
                        System.out.println("\n===== Thread Status =====");
                        printThreadStatus(counterA, "Counter-A");
                        printThreadStatus(counterB, "Counter-B");
                        break;

                    case 5:
                        System.out.println("Available tickets: " + pool.getAvailableTickets());
                        break;

                    case 6:
                        System.out.println("Waiting for all counters to finish (join)...");
                        if (counterA != null && counterA.isAlive()) counterA.join();
                        if (counterB != null && counterB.isAlive()) counterB.join();
                        System.out.println("All counters finished selling.");
                        System.out.println("Final available tickets: " + pool.getAvailableTickets());
                        break;

                    case 7:
                        System.out.print("Enter new total tickets count: ");
                        int total = Integer.parseInt(sc.nextLine().trim());
                        pool.reset(total);
                        counterA = null;
                        counterB = null;
                        System.out.println("Ticket pool reset to: " + total);
                        break;

                    case 8:
                        System.out.println("Exiting simulator. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Choose between 1 and 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
            } catch (InterruptedException e) {
                System.out.println("Error: Thread operation was interrupted.");
            }
        }
        sc.close();
    }

    private static void printThreadStatus(Thread t, String defaultName) {
        if (t == null) {
            System.out.println("Name: " + defaultName + " | Priority: Not Set | Alive: false");
        } else {
            System.out.println("Name: " + t.getName() + " | Priority: " + t.getPriority() + " | Alive: " + t.isAlive());
        }
    }
}
