package org.usfirst.frc.team4859.robot.ThrottleLookup;

public class ThrottleLookup 
{

		// SlowY
		public static double[][] correctionTable1 = {
			{.02, .25, .500, .75, 1.00},
			{.000, .10, .225, .35, 0.50}};
		
		// NormY
		public static double[][] correctionTable2 = {
			{.02, .25, .50, .75, 1.0},
			{.000, .15, .35, .60, 1.0}};
		
		// SlowX
		public static double[][] correctionTable3 = {
			{.02, .25, .500, .75, 1.0},
			{.000, .10, .225, .35, 0.5}};

		// NormX
		public static double[][] correctionTable4 = {
			{.02, .25, .50, .75, 1.0},
			{.000, .15, .35, .60, 1.0}};

		// SlowT
		public static double[][] correctionTable5 = {
			{.02, .25, .5, .75, 1.0},
			{.000, .15, .3, .45, 0.6}};

		// NormT
		public static double[][] correctionTable6 = {
			{.02, .25, .50, .75, 1.00},
			{.000, .15, .35, .60, 0.85}};
	
	public static double calcJoystickCorrection(String tableName, double x)
	{
		double[][] correctionTable;
		
		switch (tableName)
		{
			case "SlowY" : correctionTable = correctionTable1;
				break;
			case "NormY" : correctionTable = correctionTable2;
				break;
			case "SlowX" : correctionTable = correctionTable3;
				break;
			case "NormX" : correctionTable = correctionTable4;
				break;
			case "SlowT": correctionTable = correctionTable5;
				break;
			case "NormT": correctionTable = correctionTable6;
				break;
			default : correctionTable = correctionTable1;
		}
		boolean isNegative = x < 0;
		
		x = Math.abs(x);
		
		int pos = 0; 
		double returnValue;
		
		while ((pos < 5) && (x > correctionTable[0][pos]))
		{
			pos++;
		}
		
		if (pos < 5)
		{
			if (pos != 0)
			{
				double y1 = correctionTable[1][pos];
				double y2 = correctionTable[1][pos-1];
				double x1 = correctionTable[0][pos];
				double x2 = correctionTable[0][pos-1];
				returnValue = y1 + ((y1-y2)/(x1-x2)) * (x-x1);
			}
			else
			{
				return 0.0;
			}
		}
		else
		{
			return 1.0;
		}
		
		if (isNegative)
			returnValue = -returnValue;
		
		return returnValue;
	}
}