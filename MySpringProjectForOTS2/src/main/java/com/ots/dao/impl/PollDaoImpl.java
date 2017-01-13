package com.ots.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ots.dao.PollDao;
import com.ots.entity.Poll;
import com.ots.entity.Status;
import com.ots.entity.Vote;

public class PollDaoImpl implements PollDao {
	private static List<Poll> polls = new ArrayList<>();

	@Override
	public int createPoll(Poll poll) {
		poll.setStatus(Status.created);
		if (poll.getId() == 0) {
			poll.setId(poll.getNewId());
			for (Vote vote : poll.getVotes()) {
				vote.setId(poll.getNewId());
				vote.setIdPoll(poll.getId());
			}
		}
		polls.add(poll);
		return 0;
	}

	@Override
	public void startPoll(int id) {
		for (int i = 0; i < polls.size(); i++) {
			if (polls.get(i).getId() == id) {
				polls.get(i).setStatus(Status.started);
				break;
			}
		}

	}

	@Override
	public void finishPoll(int id) {
		for (Poll poll : polls) {
			if (poll.getId() == id) {
				poll.setStatus(Status.finished);
			}
		}
	}

	@Override
	public Poll getPollById(int id) {
		for (Poll poll : polls) {
			if (poll.getId() == id) {
				return poll;
			}
		}
		return null;
	}

	@Override
	public void vote(int idVote) {
		for (Poll poll : polls) {
			for (Vote vote : poll.getVotes()) {
				if (vote.getId() == idVote) {
					vote.inc();
					break;
				}
			}
		}

	}

	@Override
	public List<Poll> getPolls() {
		return polls;
	}
	@Override
	public Set<Vote> getResultsPoll(int id) {
		for (Poll poll : polls) {
			if (poll.getId() == id) {
				return poll.getVotes();
			}
		}
		return null;
	}

}
