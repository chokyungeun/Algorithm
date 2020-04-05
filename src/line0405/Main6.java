package line0405;

import java.io.*;
import java.util.*;

public class Main6 {

	public static void main(String[] args) throws Exception {
		String[] directory = {"/"};
		String[] command = {"mkdir /a",
				"mkdir /a/b",
				"mkdir /a/b/c",
				"cp /a/b /",
				"rm /a/b/c"};

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < directory.length; i++) {
			list.add(directory[i]);
		}

		for (int i = 0; i < command.length; i++) {
			String[] cmd = command[i].split(" ");
			if (cmd[0].equals("mkdir")) {
				list.add(cmd[1]);
			} 
			else if (cmd[0].equals("rm")) {
				for (int k = 0; k < list.size();) {
					boolean flag = true;
					for (int j = 0; j < cmd[1].length(); j++) {
						if (list.get(k).length() >= cmd[1].length()) {
							if (cmd[1].charAt(j) != list.get(k).charAt(j)) {
								flag = false;
								break;
							}
						}
						else {
							flag = false;
						}
					}
					if (flag) {
						list.remove(k);
					} else
						k++;
				}
			} else if (cmd[0].equals("cp")) {
				for (int k = 0; k < list.size(); k++) {
					boolean flag = true;
					for (int j = 0; j < cmd[1].length(); j++) {
						if (list.get(k).length() >= cmd[1].length()) {
							if (cmd[1].charAt(j) != list.get(k).charAt(j)) {
								flag = false;
								break;
							}
						}
						else {
							flag = false;
						}
					}
					if (flag) {
						String s = "";
						if(cmd[2].equals("/")) {
							s += list.get(k);
						}
						else {
							s += cmd[2];
							s += list.get(k);
						}
						list.add(s);
					}
				}
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		System.out.println(Arrays.toString(answer));
	}

}
