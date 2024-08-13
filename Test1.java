package com.demo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file=new File("/home/kavin/Documents/FS_training/Scores.txt");
		
		FileReader fread=new FileReader(file);
		BufferedReader bf=new BufferedReader(fread);
		
		HashMap<String,Integer> hm=new HashMap<>();
		String content=bf.readLine();
		while(content!=null)
		{
			//converting the line into String array
			
			String[] arr=content.split(" ");
			String temp="";
			for(int i=0;i<arr.length-1;i++)
			{
				temp+=arr[i];
				temp+=" ";
			}
			temp=temp.trim();
			
			//arr[last index] contains the score of the player
			hm.put(temp, Integer.parseInt(arr[arr.length-1]));
			
			//player name as key and score as value in hashmap
			content=bf.readLine();
		}
		
		fread.close();
		bf.close();
		int max=0;
		String player="";
		for(int val:hm.values())
		{
			if(val>max)
			{
				max=val;
			}
		}
		
		
		for(String value:hm.keySet())
		{
			if(hm.get(value)==max)
				player=value;
		}
		
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bw=new BufferedWriter(fw);
		//bw.flush();
		bw.newLine();
		bw.write("Player with Highest Score : ");
		bw.newLine();
		bw.write(player+" "+max);
		bw.close();

		System.out.println("File Successfully Updated");
		
	}

}
