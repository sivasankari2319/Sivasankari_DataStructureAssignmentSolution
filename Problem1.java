
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Problem1 {

	public static void main(String[] args) {

		Set<Integer> distinctFloorSizes = new LinkedHashSet<>();

		Set<Integer> reverseOrderFloorSizes = new TreeSet<>(Comparator.reverseOrder());

		Scanner in = new Scanner(System.in);

		System.out.println("enter the total no of floors in the building");
		int totalFloors = in.nextInt();

		for (int i = 1; i <= totalFloors; i++) {
			System.out.println("enter the floor size given on day: " + i);
			distinctFloorSizes.add(in.nextInt());
		}

		in.close();

		System.out.println("The order of construction is as follows");

		Optional<Integer> maxOptional = distinctFloorSizes.stream().max(Comparator.naturalOrder());
		int max = maxOptional.get();

		int i = 0;
		

		Iterator<Integer> distinctFloorSizesIterator = distinctFloorSizes.iterator();

		Iterator<Integer> reverseOrderFloorSizesIterator = null;

		while (distinctFloorSizesIterator.hasNext()) {

			System.out.println("Day: " + ++i);

			int localItem = distinctFloorSizesIterator.next();

			if (localItem < max) {
				
				reverseOrderFloorSizes.add(localItem);
				
			} else {
				System.out.print(localItem + " ");
				max--;
				reverseOrderFloorSizesIterator = reverseOrderFloorSizes.iterator();

				while (reverseOrderFloorSizesIterator.hasNext()) {
					max--;
					System.out.print(reverseOrderFloorSizesIterator.next() + " ");
					reverseOrderFloorSizesIterator.remove();
				}

				System.out.println("");
			}
		}

	}

}
