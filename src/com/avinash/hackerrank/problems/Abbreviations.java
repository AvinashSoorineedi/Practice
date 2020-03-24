package com.avinash.hackerrank.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Abbreviations {

	public static void main(String[] args) {

		System.out.println(Abbreviations.abbreviation(
				"cCccCoccocOOCCOccoccoCooCocoOoCcoCoooooOcococccOoocCoccOcoCcoooocCoooocCwcooowcocoocOococoocooOooCCooccooCCocooccoCoococccCccocoOoCcOCocccocOoOooOOooooccOcococcOOooCccooCoccOccoCcoCccOcccOoCCococCooOCoocccocoOocoOCCcoccOcOcccoOooooOOOoOcCcocCoCoOCOOcOcOOocooooocoCccocooocoooocccccooccccCCcoocococCcccCOcccccOoooOoooCcocccooocoCccOCCCccooccOwcCoccCcCcccocooOocCocccoOccocooccOocccooocooccOcccocoocoOOCOocOoococooOoOcocoocOcCcococcocCcoCoCOoOcoOOccoCcOoococoCooocccCooccCCcccCOooocoCOoOCcCccccocwcoCCOOcOoOccccCcocoCCococcCooOCcocccocOcocoocooooCoccccooOccCocoOOocococooOcccCocoOoccoCoocOccOoOOooooooocCoocCCcccococoooocCcoOooooOCcOccCooooOoocccccocoOocoCccCCcwOoOcocoocoOocccoOoCccocoocccccccooowccccOcCCoocooocOooococOOoooccoOwooOCccccoooocCooooooooooCwcooCcccoOcCoooOoOcwOoCoCcCocwoOOCcoocOOcCooocOoOooOoOccOcccocCoOcOcocoococcOoooccccccCoCooCcoooocCccOCccCooCcoOCcocoocOcoocoooOocCcCcoocoCOoOoocooCococoOccCoCoooocOoooOcoooCccocoocococOcOCccccoocccccccCooOoowoOcooOcCCOoCccCocooccoccoCCoccocOcccCo",
				"CCCOOCCOCOCOCOOCCCOOCOCOCOCOCCCOOCOOCOOWCOOOOOOOOOOCCOOCCCCCOCOCOOCOCOOOOOOOOOOOCCOCOOCCCCCOCOOCCCCOCOCCOOOOCCCOCOOCOOOOOOOCCCCOOCOOCOOOOOOCCOOOOCCCCCCCCOCCCCOOOOOCOCOCCOCCCCOCOCCCCCCCOOCCOCCOCCOOOCOOOOCOOOOOOCCOOCCOOCOCCCCOOOOOOOCOCOCCCCCCOOOCCOOCCCCCCOOCOOCCCCCOOCCCOCCCOCOOCOCCOCCOOOOOOOOOCCOOOCCOCOOOOOOOOCCCCOCOOCCOOOCOCCOOOOCOOOCCCWOOOCCOOCCOCCOCCOOCOCCCOCOOOOOCOOOCCCCCOCOCOOCOOWOOCCCOOOCCOOOCCOOCOOOOOOCOCCCOOCCCOOCOCOCOCCCCOCCCCOCCOOOOOCCOCCOOOOCOOCCCOOOCOOOOCCCOCOCCCOCCOOOCCOOCCCOOCCOCOOCC"));

	}

	public static String abbreviation(String a, String b) {

		String[] targetChars = b.split("");

		List<String> targetList = Arrays.asList(targetChars);

		String[] sourceChars = a.split("");

		List<String> sourceList = Arrays.asList(sourceChars);

		List<String> finalList = new ArrayList<String>();

		List<String> newList = sourceList.stream().filter(e -> {
			return (targetList.contains(e.toUpperCase()) || StringUtils.isAllUpperCase(e));
		}).collect(Collectors.toList());

		System.out.println(targetList);
		System.out.println(newList);

		if (targetList.size() > newList.size()) {
			return "NO";
		}

		int i = 0, j = 0;
		while (j < targetList.size()) {

			if (i >= newList.size()) {
				return "NO";
			}

			if (!targetList.get(j).equalsIgnoreCase(newList.get(i))
					&& (StringUtils.isAllLowerCase(newList.get(i)) || (StringUtils.isAllUpperCase(newList.get(i))
							&& checkIfListContainsNumber(finalList, newList.get(i))))) {
				i++;
			} else if (!targetList.get(j).equalsIgnoreCase(newList.get(i))
					&& StringUtils.isAllUpperCase(newList.get(i))) {
				System.out.println("i index " + i + " j index " + j + " j element is " + targetList.get(j)
						+ " i element is " + newList.get(i));
				return "NO";
			} else {
				if (StringUtils.isAllLowerCase(newList.get(i))) {
					finalList.add(newList.get(i));
				}
				i++;
				j++;
			}

		}

		for (; i < newList.size(); i++) {
			//if (StringUtils.isAllUpperCase(newList.get(i)) && !targetList.get(j - 1).equalsIgnoreCase(newList.get(i))) {
			if (StringUtils.isAllUpperCase(newList.get(i)) && !finalList.subList(finalList.size()-3, finalList.size()).contains(newList.get(i))) {
				return "NO";
			}
		}

		return "YES";
	}

	private static boolean checkIfListContainsNumber(List<String> finalList, String string1) {
		for (int i = finalList.size() - 1; i >= 0; i--) {
			if (finalList.get(i).equals(StringUtils.swapCase(string1))) {
				return true;
			}
		}

		return false;
	}

}
