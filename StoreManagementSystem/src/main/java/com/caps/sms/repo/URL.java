package com.caps.sms.repo;



	public class URL {
		
		
		public static String getURL()
		{
			String url = "jdbc:mysql://localhost:3306/store_db?user=root&password=1234";
			return url;
		}
		public  static String getDriver()
		{
			String url = "com.mysql.cj.jdbc.Driver";
			return url;
		}

		
		public  static String getProperty()
		{
			String url = " C:\\PLPWorkspace\\db2.properties";
			return url;
		}

	}



