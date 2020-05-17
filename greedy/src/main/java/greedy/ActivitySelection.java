package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {
	
	private void activitySelection(ArrayList<Activity> activityList) {
		
		Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
			public int compare(Activity o1, Activity o2) {
				return o1.getFinishTime() - o2.getFinishTime();
			}
		};
		
		Collections.sort(activityList, finishTimeComparator);
		Activity previousActivity = activityList.get(0);	
		
		System.out.println("\nOutput Schedule:\n"+activityList.get(0));
		
		for (int i = 1; i < activityList.size() ; i++) {
			Activity activity = activityList.get(i);
			if (activity.getStartTime() >= previousActivity.getFinishTime()) {
				System.out.println(activity);
				previousActivity = activity;
			}
		}
	}

	public static void main(String[] args) {
		
		ActivitySelection as = new ActivitySelection();
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		
		activityList.add(new Activity("A1", 0, 6));
		activityList.add(new Activity("A2", 3, 4));
		activityList.add(new Activity("A3", 1, 2));
		activityList.add(new Activity("A4", 5, 8));
		activityList.add(new Activity("A5", 5, 7));
		activityList.add(new Activity("A6", 8, 9));
	
		System.out.println("Input Schedule:");
		for (int i = 0; i < activityList.size() ; i++) {
			Activity activity = activityList.get(i);
			System.out.println(activity.toString());
		}
		as.activitySelection(activityList);
	}
}
