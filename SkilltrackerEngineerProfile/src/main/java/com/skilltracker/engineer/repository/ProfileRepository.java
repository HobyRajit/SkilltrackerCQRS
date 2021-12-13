package com.skilltracker.engineer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.skilltracker.engineer.entity.Profile;
import com.skilltracker.engineer.entity.Skill;

@Repository
public class ProfileRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Profile saveProfile(Profile profile) {
		dynamoDBMapper.save(profile);
		return profile;
	}
	
	public Profile getProfileById(String associateId) {
		return dynamoDBMapper.load(Profile.class,associateId);
		
	} 
	
	public String deleteProfileById(String associateId) {
		
		dynamoDBMapper.batchDelete(dynamoDBMapper.load(Profile.class,associateId));
		return "Profile Id :"+ associateId +"deleted!";
	}
	

	public String updateProfile(String associateId, Skill skill ) {
		
		dynamoDBMapper.save(skill,new DynamoDBSaveExpression().withExpectedEntry("associateId",new ExpectedAttributeValue(
				new AttributeValue().withS(associateId)
				)));
		return associateId;
	}
	
	public String saveSkill(String associateId, Skill skill ) {
		
		dynamoDBMapper.save(skill);
		return associateId;
	}
	
	public String updateSkill(String associateId,Skill skill) {
		dynamoDBMapper.save(skill,new DynamoDBSaveExpression().withExpectedEntry("associateId",new ExpectedAttributeValue(
				new AttributeValue().withS(associateId)
				)));
		return associateId;
	}
	
	

}
