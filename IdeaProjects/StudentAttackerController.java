package edu.ufl.cise.cs1.controllers;

import game.controllers.AttackerController;
import game.models.Attacker;
import game.models.Defender;
import game.models.Game;
import game.models.Node;

import java.util.ArrayList;
import java.util.List;

public final class StudentAttackerController implements AttackerController
{
	public void init(Game game) { }

	public void shutdown(Game game) { }

	public int update(Game game,long timeDue)
	{
		int action;
		Attacker attacker = game.getAttacker(); //creates object attacker as a shortcut
		List<Defender> defenders = game.getDefenders();
		Node nearestPill = betterGetTarget(game.getPillList(), game); //TA code
		ArrayList<Node> locationOfDefenders = new ArrayList<>(); //puts the locations (int) of all defenders in an array
		Defender defender0 = game.getDefender(0); // name of defender 1 shortcut
		Defender defender1 = game.getDefender(1); //2
		Defender defender2 = game.getDefender(2);//3
		Defender defender3 = game.getDefender(3);//4
		Node nearestPowerPill = betterGetTarget(game.getPowerPillList(), game); //shortcut to make name object nearest power pill
		Node temp;

		for(int i = 0; i < defenders.size(); i++) {
			temp = game.getDefender(i).getLocation();
			locationOfDefenders.add(temp);
	}
		Node nearestDefender = betterGetTarget(locationOfDefenders, game);

		action = 0;
		if(defender0.isVulnerable() && attacker.getLocation().getPathDistance(defender0.getLocation()) < 62) { //if any vulnerable defender is within range of 62 units, we go after it
			action = attacker.getNextDir(defender0.getLocation(), true);
		}
		else if(defender1.isVulnerable() && attacker.getLocation().getPathDistance(defender1.getLocation()) < 62) {
			action = attacker.getNextDir(defender1.getLocation(), true);
		}
		else if(defender2.isVulnerable() && attacker.getLocation().getPathDistance(defender2.getLocation()) < 62) {
			action = attacker.getNextDir(defender2.getLocation(), true);
		}
		else if(defender3.isVulnerable() && attacker.getLocation().getPathDistance(defender3.getLocation()) < 62) {
			action = attacker.getNextDir(defender3.getLocation(), true);
		}
		else if(attacker.getLocation().getPathDistance(nearestDefender) > 0 && attacker.getLocation().getPathDistance(nearestDefender) <= 5) {
			action = attacker.getNextDir(nearestDefender, false);
		}
		else if(game.getPowerPillList().size() > 0 && attacker.getLocation().getPathDistance(nearestPowerPill) < 20) {
			if(attacker.getLocation().getPathDistance(nearestPowerPill) > 2) {
				action = attacker.getNextDir(nearestPowerPill, true);
			}
			else if (attacker.getLocation().getPathDistance(nearestPowerPill) < 5) { //makes the attacker pause in front of power pill by going forwards then backwards
				action = attacker.getNextDir(nearestPowerPill, false);
			}
			if(attacker.getLocation().getPathDistance(nearestDefender) < 5) {
				action = attacker.getNextDir(nearestPowerPill, true);
			}
		}
		else {
			action = attacker.getNextDir(nearestPill, true);
		}

		return action;
	}

	public static Node betterGetTarget(List<Node> node, Game game) { //TA code
		if (node.size() == 0) {
			return null;
		}
		int minDistance = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < node.size(); i++) {
			int currentDistance = node.get(i).getPathDistance(game.getAttacker().getLocation());
			if (currentDistance < minDistance) {
				minDistance = node.get(i).getPathDistance(game.getAttacker().getLocation());
				minIndex = i;
			}
		}
		return node.get(minIndex);
	}
}