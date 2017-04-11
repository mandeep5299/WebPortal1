package com.wipro.portal.dao;

import java.util.List;

import com.wipro.portal.domain.Training;

public interface TrainingEditDAO {

	  Training searchTraining(int trainingId) ;
	  Boolean updateTraining(Training training);
	  Boolean deleteTraining(Training training) ;
	  Training findByTrainingId(int trainingId); 
	
}
