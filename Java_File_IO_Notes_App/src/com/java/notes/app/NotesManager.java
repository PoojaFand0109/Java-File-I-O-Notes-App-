package com.java.notes.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileName = "notes.txt";

		while (true) {
			System.out.println("\n---Notes manager---");
			System.out.println("1. Write notes");
			System.out.println("2. Read notes");
			System.out.println("3. Exit");

			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				writeNotes(sc, fileName);
				break;

			case 2:
				readNotes(fileName);
				break;

			case 3:
				System.out.println("Exiting...Thank You!");
			}
		}
	}

	private static void writeNotes(Scanner sc, String fileName) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter(fileName, true);
			System.out.println("Enter your notes (type 'end' on a new line to stop):");

			while (true) {
				String line = sc.nextLine();
				if (line.equalsIgnoreCase("end")) {
					break;
				}
				fw.write(line + "\n");

			}
			fw.close();
			System.out.println("Notes saved successfuly");
		} catch (IOException e) {
			System.out.println("An erroe occurredwhile writing notes");
			e.printStackTrace();

		}
	}

	private static void readNotes(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			System.out.println("\n---Your Notes---");

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No notes found. Please write some notes first.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occurred while reading notes.");
			e.printStackTrace();
		}

	}
}
