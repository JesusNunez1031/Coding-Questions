import java.util.List;

public class migratoryBirds {

    /*
    You have been asked to help study the population of birds migrating across the continent. Each type of bird you are interested in will be identified by an integer value.
    Each time a particular kind of bird is spotted, its id number will be added to your array of sightings. You would like to be able to find out which type of bird is most common given a list of sightings.
    Your task is to print the type number of that bird and if two or more types of birds are equally common, choose the type with the smallest ID number.
     */

    static int migratoryBirds(List<Integer> arr) {
        int[] birds = new int[6];
        int max = 0, index = 0;

        for (int i = 0; i < arr.size(); i++) {
            birds[arr.get(i)]++;
        }

        for (int i = 0; i < birds.length; i++) {
            if (birds[i] > max) {
                max = birds[i];
                index = i;
            }
        }
        return index;
    }
}
