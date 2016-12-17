package com.geeksforgeeks.datastructures.hashing.employeesundermanager;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 2:42 PM
 * http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
 */

import java.util.*;

public class NumberEmployeeUnderManager {
    static HashMap<String, Integer> result = new HashMap<>();

    private static void populateResult(HashMap<String, String> dataSet) {
        HashMap<String, List<String>> ManagerEmpMap = new HashMap<>();
        for (HashMap.Entry<String, String> entry : dataSet.entrySet()) {
            String employee = entry.getKey();
            String manager = entry.getValue();
            if (!employee.equals(manager)) {
                List<String> directReportList = ManagerEmpMap.get(manager);
                if (directReportList == null) {
                    directReportList = new ArrayList<String>();
                }
                directReportList.add(employee);
                ManagerEmpMap.put(manager, directReportList);
            }
        }
        for (String manager : dataSet.keySet()) {
            populateResultUtil(manager, ManagerEmpMap);
        }
    }

    private static int populateResultUtil(String manager, HashMap<String, List<String>> ManagerEmpMap) {
        int count = 0;
        if (!ManagerEmpMap.containsKey(manager)) {
            result.put(manager, 0);
            return 0;
        } else if (result.containsKey(manager)) {
            count = result.get(manager);
        } else {
            List<String> directReportEmpList = ManagerEmpMap.get(manager);
            count = directReportEmpList.size();
            for (String directReportEmp : directReportEmpList) {
                count += populateResultUtil(directReportEmp, ManagerEmpMap);
            }
            result.put(manager, count);
        }
        return count;
    }

    public static void main(String[] args) {
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        populateResult(dataSet);
        System.out.println(result);
    }
}
