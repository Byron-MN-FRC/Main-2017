package org.usfirst.frc.team4859.robot.ThrottleLookup;

public class ThrottleLookup 
{
	

		// SlowY
		public static double[][] correctionTable1 = {
			{.01, .25, .50, .75, 1.0},
			{.00, .08, .12, .20, .40}};
		// NormY
		public static double[][] correctionTable2 = {
			{.01, .25, .50, .75, 1.0},
			{.00, .12, .27, .7, 1.0}};

		// SlowT
		public static double[][] correctionTable3 = {
			{.01,  .25,  .50,  .75,  1.0},
			{.00, .06, .10, .30, .50}};

		// NormT
		public static double[][] correctionTable4 = {
			{.01,  .25,  .50,  .75,  1.0},
			{.00, .15, .25, .55, 0.8}};
	
	public static double calcJoystickCorrection(String tableName, double x)
	{
		double[][] correctionTable;
		
		switch (tableName)
		{
			case "SlowY" : correctionTable = correctionTable1;
				break;
			case "NormY" : correctionTable = correctionTable2;
				break;
			case "SlowT": correctionTable = correctionTable3;
				break;
			case "NormT": correctionTable = correctionTable4;
				break;
			default : correctionTable = correctionTable1;
		}
		boolean isNegative = x < 0;
		
		x = Math.abs(x);
		
		int pos = 0; 
		double returnValue;
		
		while ((pos < 5) && (x > correctionTable1[0][pos]))
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
				return 0;
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
