package com.nurdinaffandidev.thread_livelock;
import java.util.Random;

// NOTE: uncomment lines with 🟢 to see livelock
// 🟢: added to solve livelock using backoff
// 🟢🟢: added to solve sleep randomness that isn’t strong enough to break the symmetry
public class Diner {
    // Attributes
    private String name;
    private boolean isHungry = true;
    private final Random random = new Random(); // 🟢
    private int politeness = 5; // max times to be polite 🟢🟢

    // Constructor
    public Diner(String name) {
        this.name = name;
    }

    // Getter Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setIsHungry(boolean hungry) {
        isHungry = hungry;
    }

    // Methods
    public void eatWith(Spoon spoon, Diner partner) {
        while (isHungry) {
            if (spoon.getDiner() != this) {
                try { Thread.sleep(1); } catch (Exception e) { e.printStackTrace(); }
                continue;
            }

//            if (partner.isHungry) { // original code resulting in livelock
            if (partner.isHungry && politeness > 0) { // 🟢🟢
                System.out.println(name + ": You go first " + partner.getName());
                politeness--; // 🟢🟢
                //  Add backoff delay to avoid livelock
                try {
                    Thread.sleep(random.nextInt(20)); // Random wait 0–9 ms 🟢
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spoon.setDiner(partner);
                continue;
            }

            spoon.use();
            isHungry = false;
            System.out.println(name + " is done eating.");
            spoon.setDiner(partner);
        }
    }
}
