package lt.vtvpmc.ems.akademijait;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;
import org.apache.log4j.Logger;

/**
 * 
 * This class implements SocialNetwork interface and overrides its methods
 * @author Daiva Urbutiene
 * 
 */

public class MySocialNetwork implements SocialNetwork {
	
	 final static Logger logger = Logger.getLogger(MySocialNetwork.class);

	protected List<Friend> friendList = new ArrayList<Friend>();
	protected Collection<Friend> friendListByCity = new ArrayList<Friend>();
	
	/**
	 * 
	 * This method can add new friend to the friends collection.
	 * @param friend -
	 * @throws IllegalArgumentException if given param  - empty
	 * 
	 */
	public void addFriend(Friend friend) {
		if (friend == null) {
logger.info("Fiend parameters was null, so friend was not added");
			throw new IllegalArgumentException();
		}
				if (!friendList.contains(friend)) {
			friendList.add(friend);
logger.info("New friend was added");
		}

	}

	/**
	 * 
	 * This method can find friends by city in the friends collection.
	 * @param city -
	 * @throws IllegalArgumentException if given param  - empty
	 * @return Collection
	 * 
	 */
	@Override
	public Collection<Friend> findByCity(String city) {
		if (city == null) {
logger.warn("Parameter - city was null");			
			throw new IllegalArgumentException();
		}
		
		for (Friend friend : friendList) {
			if (friend.getCity().equals(city)) {
				friendListByCity.add(friend);
			} else
				continue;
		}
logger.info("Find friend by City");
		return friendListByCity;
	}
	/**
	 * 
	 * This method can find friends by first name and last name in the friends collection.
	 * @param firstName -
	 * @param lastName -
	 * @throws IllegalArgumentException if given param  - empty
	 * @throws FriendNotFoundException if  params have already exist 
	 * @return Friend
	 * 
	 */
	@Override
	public Friend findFriend(String firstName, String lastName) throws FriendNotFoundException {
		if (firstName == null || lastName == null ) {
			throw new IllegalArgumentException();
		}
		Friend result = null;
		for (Friend friend : friendList) {
			if (friend.getFirstName().equals(firstName) && friend.getLastName().equals(lastName)) {
				result = friend;
				break;
			} else
				continue;
		}
		if (result == null) {
			throw new FriendNotFoundException(firstName,lastName);
		
		};
		logger.info("Looking for a frined");
		return result;
	}

	/**
	 * 
	 * This method can get Number Of Friends in the friends collection.
	 * @return size
	 * 
	 */
	@Override
	public int getNumberOfFriends() {
		int size = friendList.size();
//  Arba taip:
//		int size = 0;
//		for (Friend friend : friendList) {
//			size += 1;
//		}
		logger.info("Returns number of friends");
		return size;
	}
	
	/**
	 * 
	 * This method can get Ordered Friends
	 * @return Collection 
	 * 
	 */
	@Override
	public Collection<Friend> getOrderedFriends() {
	
		List<Friend> orderedFriendList = new ArrayList<>(friendList);
		if (friendList.isEmpty()) {
			orderedFriendList = Collections.emptyList();
		} else {
			orderedFriendList.sort(Comparator.comparing(Friend::getCity).thenComparing(Friend::getLastName).thenComparing(Friend::getFirstName));
			
		}
		logger.info("Returns ordered list of friends");
			return orderedFriendList;
	}

}
