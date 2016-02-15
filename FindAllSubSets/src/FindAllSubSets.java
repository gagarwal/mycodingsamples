
import java.util.ArrayList;

/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/
 * IDeserve</a> Starts from an empty set to generate all possible subsets of
 * given set using recursion
 * 
 * @author Nilesh
 */

public class FindAllSubSets {

	private ArrayList<Integer> cloneSet(ArrayList<Integer> input) {

		ArrayList<Integer> clone = new ArrayList<Integer>();

		for (int i = 0; i < input.size(); i++) {
			clone.add(input.get(i));
		}

		return clone;
	}

	public void findAllSubsets(ArrayList<ArrayList<Integer>> allSubsets, ArrayList<Integer> set, int currIndex) {

		/*
		 * base case: if all elements of given set are considered for all
		 * possible subsets
		 */
		if (currIndex == set.size()) {
			return;
		}

		/*
		 * need to get the size in advance since adding new sets to allSubsets
		 * will increase its size dynamically.
		 */
		int allSubSetsSize = allSubsets.size();
		ArrayList<Integer> newSet;

		/*
		 * for each set - allSubsets[i] in allSubsets: 1. create new set by
		 * adding element placed at 'currIndex' in the given set 2. add this
		 * newly created set to 'allSubsets'
		 */
		for (int i = 0; i < allSubSetsSize; i++) {
			newSet = cloneSet(allSubsets.get(i));

			newSet.add(set.get(currIndex));

			allSubsets.add(newSet);
		}

		/*
		 * include next element from given set in allSubsets
		 */
		findAllSubsets(allSubsets, set, currIndex + 1);
	}

	public ArrayList<ArrayList<Integer>> findAllSubsets(ArrayList<Integer> set) {

		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();

		// add empty set to all possible subsets
		allSubsets.add(new ArrayList<Integer>());

		// use empty set to generate all possible subsets of given set using
		// recursion
		findAllSubsets(allSubsets, set, 0);

		return allSubsets;
	}

	public static void main(String[] args) {
		FindAllSubSets solution = new FindAllSubSets();

		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);

		ArrayList<ArrayList<Integer>> allSubsets = solution.findAllSubsets(set);

		// only 2^n-1 subsets would be printed. Empty subset is not printed.
		for (int i = 0; i < allSubsets.size(); i++) {

			ArrayList<Integer> tempSet = allSubsets.get(i);

			for (int j = 0; j < tempSet.size(); j++) {
				System.out.print(tempSet.get(j) + ", ");
			}

			System.out.print("\n");
		}
	}
}

