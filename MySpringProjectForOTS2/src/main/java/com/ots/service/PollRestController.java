package com.ots.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ots.dao.impl.PollDaoImpl;
import com.ots.entity.Poll;
import com.ots.entity.Vote;

@RestController
@RequestMapping(value = "/poll")
public class PollRestController {
	private PollDaoImpl impl = new PollDaoImpl();

	@RequestMapping(method = RequestMethod.GET)
	List<Poll> getPolls() {
		return impl.getPolls();
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	Poll getPoll(@PathVariable int id) {
		return impl.getPollById(id);
	}
	@RequestMapping(value = "/results/{id}",method = RequestMethod.GET)
	Set<Vote> getResultsPoll(@PathVariable int id) {
		return impl.getResultsPoll(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	boolean add(@RequestBody Poll poll) {
		impl.createPoll(poll);
		return true;
	}

	@RequestMapping(value = "/start/{id}", method = RequestMethod.PUT)
	void startPoll(@PathVariable int id) {
		impl.startPoll(id);
	}

	@RequestMapping(value = "/finish/{id}", method = RequestMethod.PUT)
	void finishPoll(@PathVariable int id) {
		impl.finishPoll(id);
	}

	@RequestMapping(value = "/vote/{idVote}", method = RequestMethod.PUT)
	void vote(@PathVariable int idVote, @RequestBody int idPoll) {
		impl.vote(idVote);
	}
}
