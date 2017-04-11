package com.wipro.portal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.wipro.portal.domain.Training;

public interface SearchTrainingDAO {
	public List<Training> SearchTraining(HttpSession sesion);
}
