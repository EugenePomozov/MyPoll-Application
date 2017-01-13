package com.ots.dao;

import java.util.List;
import java.util.Set;

import com.ots.entity.Poll;
import com.ots.entity.Vote;

public interface PollDao {
	int createPoll(Poll poll);
	void startPoll(int id);
	void finishPoll(int id);
	Poll getPollById(int id);
	void vote(int idVote);
	List<Poll> getPolls();
	Set<Vote> getResultsPoll(int id);
	

}
