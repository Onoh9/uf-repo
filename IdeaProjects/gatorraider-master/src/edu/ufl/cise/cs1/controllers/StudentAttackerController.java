package edu.ufl.cise.cs1.controllers;

import game.controllers.AttackerController;
import game.models.Attacker;
import game.models.Defender;
import game.models.Game;
import game.models.Node;
import java.util.List;

public final class StudentAttackerController implements AttackerController {
	public void init(Game game) { }

	public void shutdown(Game game) { }

	public int update(Game game, long timeDue) {
		Attacker attacker = game.getAttacker();

		Pair<Defender,Integer> result = closestDefender(game, false);
		Defender preyDefender = result.first();
		int preyDefenderLength = result.second();

		result = closestDefender(game, true);
		Defender regularDefender = result.first();
		int regularDefenderLength = result.second();


		if(regularDefender != null && (regularDefenderLength <= preyDefenderLength && regularDefenderLength <= 6)){
			return game.getAttacker().getNextDir(regularDefender.getLocation(), false);
		}
		else if(preyDefender != null){
			return game.getAttacker().getNextDir(preyDefender.getLocation(), true);
		}else if (closePowerPill(game)){
			if(regularDefenderLength <= 7){
				return eatPowerPill(game);
			}
			return game.getAttacker().getReverse();
		}
		else if(regularDefenderLength <= 7){
			return game.getAttacker().getNextDir(regularDefender.getLocation(), false);
		}
		else return eatPowerPill(game);

	}


	private int eatPowerPill(Game game) {

		Node _nodePowerPill = game.getAttacker().getTargetNode(game.getPowerPillList(), true);
		Node _nodePill = game.getAttacker().getTargetNode(game.getPillList(), true);
		try {
			return game.getAttacker().getNextDir(_nodePowerPill, true);
		} catch (NullPointerException e) {
			return game.getAttacker().getNextDir(_nodePill, true);
		}
	}


	private Pair<Defender,Integer> closestDefender(Game game, boolean bool) {

		Defender defender = null;
		int tempInt = Integer.MAX_VALUE;

		Node attackerLocation = game.getAttacker().getLocation();
		if (bool) {
			for (int i = 0; i < 4; i++) {

				Defender temp = game.getDefenders().get(i);
				if (tempInt > temp.getPathTo(attackerLocation).size() && !temp.isVulnerable() && temp.getLairTime() == 0 ) {
					defender = temp;
					tempInt =   temp.getPathTo((attackerLocation)).size();
				}
			}
		} else {

			for (int i = 0; i < 4; i++) {

				Defender temp = game.getDefenders().get(i);
				if (tempInt > attackerLocation.getPathDistance(temp.getLocation()) && temp.isVulnerable()) {
					defender = temp;
					tempInt = attackerLocation.getPathDistance(temp.getLocation());

				}
			}
		}
		return new Pair<>(defender,tempInt);
	}



	private boolean closePowerPill(Game game) {
		List<Node> nodes =  game.getAttacker().getLocation().getNeighbors();
		for(int i = 0; i < nodes.size(); i ++) {
			if (nodes.get(i) != null && game.checkPowerPill(nodes.get(i))) {
				return true;
			}
		}
		return false;

	}



}








/*
public final class StudentAttackerController implements AttackerController
{
	public void init(Game game) { }

	public void shutdown(Game game) { }

	public int update(Game game,long timeDue)
	{
		int action;

		//Chooses a random LEGAL action if required.
		List<Integer> possibleDirs = game.getAttacker().getPossibleDirs(true);
		if (possibleDirs.size() != 0)
			action = possibleDirs.get(Game.rng.nextInt(possibleDirs.size()));
		else
			action = -1;

		return action;
	}
}

 */