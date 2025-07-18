/*FoodFest – Sorting Stalls by Customer Footfall (Merge Sort)
Story: At a multi-day food festival, organizers track footfall at every stall each day. They collect
daily logs from all zones (already sorted by count), and use Merge Sort to combine zone-wise
data into a master list for performance evaluation.
Concepts Involved:
● Merge Sort
● Combining multiple sorted datasets
● Stability in data with equal values */

class Stall {
    String name;
    int footfall;

    public Stall(String name, int footfall) {
        this.name = name;
        this.footfall = footfall;
    }
}

public class Food_Fest_Merge_Sort {
    public static void main(String[] args) {
        Stall[] northZone = {
            new Stall("StallA", 100),
            new Stall("StallB", 150),
            new Stall("StallC", 200)
        };

        Stall[] southZone = {
            new Stall("StallD", 90),
            new Stall("StallE", 150),
            new Stall("StallF", 250)
        };

        Stall[] merged = mergeSortedZones(northZone, southZone);
        System.out.println("Master List - Stalls sorted by customer footfall:"); 
        for (Stall s : merged) {
            System.out.println(s.name + " - " + s.footfall + " visitors");
        }
    }

    public static Stall[] mergeSortedZones(Stall[] zone1, Stall[] zone2) {
        int i = 0, j = 0, k = 0;
        Stall[] merged = new Stall[zone1.length + zone2.length];

        while (i < zone1.length && j < zone2.length) {
            if (zone1[i].footfall <= zone2[j].footfall) {
                merged[k++] = zone1[i++];
            } else {
                merged[k++] = zone2[j++];
            }
        }
        while (i < zone1.length) {
            merged[k++] = zone1[i++];
        }
        while (j < zone2.length) {
            merged[k++] = zone2[j++];
        }

        return merged;
    }
}
