package kenyonprater.com.github.changegame.helper;

import java.util.HashMap;

import kenyonprater.com.github.changegame.world.Trigger;

public class WorldRefs {

	public static String[] house = {"/res/lvl/1-1.tmx","/res/lvl/1-1.tmx","/res/blankmap.tmx","/res/lvl/3-9.tmx"};
	public static String[] carrousel = {"/res/lvl/1-2.tmx","/res/lvl/1-2.tmx","/res/blankmap.tmx","/res/lvl/3-8.tmx"};
	public static String[] barn = {"/res/lvl/1-3.tmx","/res/lvl/1-3.tmx","/res/blankmap.tmx","/res/lvl/3-7.tmx"};
	public static String[] road = {"/res/lvl/1-4.tmx","/res/lvl/1-4.tmx","/res/blankmap.tmx","/res/lvl/3-6.tmx"};
	public static String[] school = {"/res/lvl/1-5.tmx","/res/lvl/1-5.tmx","/res/lvl/2-2.tmx","/res/lvl/3-4.tmx"};
	public static String[] insideschool = {"/res/lvl/1-6.tmx","/res/lvl/1-6.tmx","/res/lvl/2-1.tmx","/res/lvl/3-5.tmx"};
	public static String[] field = {"/res/lvl/2-3.tmx","/res/blankmap.tmx","/res/lvl/2-3.tmx","/res/lvl/3-3.tmx"};
	public static String[] hosp = {"/res/lvl/2-4.tmx","/res/blankmap.tmx","/res/lvl/2-4.tmx","/res/lvl/3-2.tmx"};
	public static String[] doc = {"/res/lvl/2-5.tmx","/res/blankmap.tmx","/res/lvl/2-5.tmx","/res/lvl/3-1.tmx"};
	
	public static HashMap<String, String[]> rooms = new HashMap<String, String[]>();
	
	
	public static Trigger[] house1 = {new Trigger(640, 400, 50, false, "GOTO carrousel 70 400 1")};
	public static Trigger[] house2 = {};
	public static Trigger[] house3 = {new Trigger(640, 400, 50, false, "GOTO carrousel 70 400 3")};
	
	public static Trigger[] carrousel1 = {new Trigger(0, 400, 50, false, "GOTO house 570 400 1"),new Trigger(960, 400, 50, false, "GOTO barn 70 400 1")};
	public static Trigger[] carrousel2 = {};
	public static Trigger[] carrousel3 = {new Trigger(0, 400, 50, false, "GOTO house 570 400 3"), new Trigger(960, 400, 50, false, "GOTO barn 70 400 3")};
	
	public static Trigger[] barn1 = {new Trigger(0, 400, 50, false, "GOTO carrousel 870 400 1"),new Trigger(960, 400, 50, false, "GOTO road 70 370 1")};
	public static Trigger[] barn2 = {};
	public static Trigger[] barn3 = {new Trigger(0, 400, 50, false, "GOTO carrousel 870 400 3"),new Trigger(960, 400, 50, false, "GOTO road 70 370 3")};
	
	public static Trigger[] road1 = {new Trigger(0, 370, 50, false, "GOTO barn 870 400 1"),new Trigger(640, 370, 50, false, "GOTO school 70 370 1")};
	public static Trigger[] road2 = {};
	public static Trigger[] road3 = {new Trigger(0, 370, 50, false, "GOTO barn 870 400 3"),new Trigger(640, 370, 50, false, "GOTO school 70 370 3")};
	
	public static Trigger[] school1 = {new Trigger(0, 370, 50, false, "GOTO road 570 370 1"),new Trigger(572, 370, 50, true, "GOTO insideschool 200 390 1")};
	public static Trigger[] school2 = {new Trigger(800, 370, 50, false, "GOTO field 70 400 2"),new Trigger(572, 370, 50, true, "GOTO insideschool 200 390 2")};
	public static Trigger[] school3 = {new Trigger(0, 370, 50, false, "GOTO road 570 370 3"),new Trigger(800, 370, 50, false, "GOTO field 70 430 3"),new Trigger(572, 370, 50, true, "GOTO insideschool 200 370 3")};
	
	public static Trigger[] insideschool1 = {new Trigger(120, 400, 50, true, "GOTO school 650 370 1"),new Trigger(215, 400, 5, false, "GOTO insideschool 215 370 2")};
	public static Trigger[] insideschool2 = {new Trigger(120, 400, 50, true, "GOTO school 650 370 2")};
	public static Trigger[] insideschool3 = {new Trigger(120, 400, 50, true, "GOTO school 650 370 3")};
	
	public static Trigger[] field1 = {};
	public static Trigger[] field2 = {new Trigger(1280, 430, 50, false, "GOTO hosp 70 370 2")};
	public static Trigger[] field3 = {new Trigger(0, 430, 50, false, "GOTO school 730 370 3"),new Trigger(1280, 400, 50, false, "GOTO hosp 70 370 3")};
	
	public static Trigger[] hosp1 = {};
	public static Trigger[] hosp2 = {new Trigger(570, 400, 50, true, "GOTO doc 160 430 2")};
	public static Trigger[] hosp3 = {new Trigger(570, 400, 50, true, "GOTO doc 160 430 3"),new Trigger(0, 400, 50, false, "GOTO field 1210 400 3")};
	
	public static Trigger[] doc1 = {};
	public static Trigger[] doc2 = {new Trigger(80, 400, 50, true, "GOTO hosp 500 370 2"),new Trigger(480, 400, 5, false, "GOTO doc 480 430 3")};
	public static Trigger[] doc3 = {new Trigger(80, 400, 50, true, "GOTO hosp 500 370 3")};
	
	public static HashMap<String, Trigger[]> triggers = new HashMap<String, Trigger[]>();
	
	public static void init()
	{
		rooms.put("house", house);
		rooms.put("carrousel", carrousel);
		rooms.put("barn", barn);
		rooms.put("road", road);
		rooms.put("school", school);
		rooms.put("insideschool", insideschool);
		rooms.put("field", field);
		rooms.put("hosp", hosp);
		rooms.put("doc", doc);
		
		
		triggers.put("house1", house1);
		triggers.put("house2", house2);
		triggers.put("house3", house3);
		triggers.put("carrousel1", carrousel1);
		triggers.put("carrousel2", carrousel2);
		triggers.put("carrousel3", carrousel3);
		triggers.put("barn1", barn1);
		triggers.put("barn2", barn2);
		triggers.put("barn3", barn3);
		triggers.put("road1", road1);
		triggers.put("road2", road2);
		triggers.put("road3", road3);
		triggers.put("school1", school1);
		triggers.put("school2", school2);
		triggers.put("school3", school3);
		triggers.put("insideschool1", insideschool1);
		triggers.put("insideschool2", insideschool2);
		triggers.put("insideschool3", insideschool3);
		triggers.put("field1", field1);
		triggers.put("field2", field2);
		triggers.put("field3", field3);
		triggers.put("hosp1", hosp1);
		triggers.put("hosp2", hosp2);
		triggers.put("hosp3", hosp3);
		triggers.put("doc1", doc1);
		triggers.put("doc2", doc2);
		triggers.put("doc3", doc3);
	}
	
}
