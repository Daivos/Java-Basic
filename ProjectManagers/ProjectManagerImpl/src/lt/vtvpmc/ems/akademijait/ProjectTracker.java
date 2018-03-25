package lt.vtvpmc.ems.akademijait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.istack.internal.logging.Logger;

import lt.itakademija.exam.Issue;
import lt.itakademija.exam.Project;
import lt.itakademija.exam.ProjectManager;


/**
 * 
 * *MyProjectTracker is used to:
 * 1.Create new project by given project param ID and Summary
 * 2.Get all created projects
 * 3.Get project by givent param project ID
 * 4.Create new issuse with given param project and summary
 * 5.Create new Issues with given param project id and summary
 * 6.Get all issues by given param project
 * 7.Get all issues by givent param project id 
 * 
 * @author daiva
 *
 */
public class ProjectTracker implements ProjectManager {
	
	final static Logger logger = Logger.getLogger(ProjectTracker.class);

	Collection<Project> projectsList = new ArrayList<>();
	Collection<Issue> issuesList = new ArrayList<>();

	
	/**
	 * 
	 * Method create new issue by given param project and issue Summary
	 * @param project Project project
	 * @param summary issue summary
	 */
	@Override
	public Issue createIssue(Project project, String summary) {
		if (project == null || summary == null) {
			logger.info("Parameters was null. Write parameters: project and summary.");
			throw new NullPointerException();
		}
		if (project.getId() == "" || project.getSummary() == "" || summary.equals("")) {
			throw new IllegalArgumentException();
		}
		Issue issue = new Issue(project, summary);
		issuesList.add(issue);
		logger.info("New issue was created and added to the issue Collection");
		return issue;
	}

	/**
	 * 
	 * Method create new issue by given param project ID and issue Summary
	 * @return issue
	 * @throws NullPointerException if one of the param is null
	 * @throws IllegalArgumentException if one of the param is empty
	 */
	@Override
	public Issue createIssue(String projectId, String summary) {
		if (projectId == null || summary == null) {
			throw new NullPointerException();
		}
		if (projectId.equals("") || summary.equals("")) {
			throw new IllegalArgumentException();
		}

		Issue issue = null;
		for (Project project : projectsList) {
			if (project.getId().equals(projectId)) {
				Project proj = project;
				issue = new Issue(proj, summary);
				issuesList.add(issue);
			}
		}
		logger.info("New issue was created by Project Id and added to the issue Collection");
		return issue;
	}

	
	/**
	 * 
	 * Method create new project by given param project ID and issue Summary
	 * @return new issue
	 * @throws NullPointerException if one of the param is null
	 * @throws IllegalArgumentException if one of the param is empty
	 * 
	 */
	@Override
	public Project createProject(String id, String summary) {
		if (id == null || summary == null) {
			throw new NullPointerException();
		}
		if (id == "" || summary == "") {
			throw new IllegalArgumentException();
		}

		Project project = new Project(id, summary);
		projectsList.add(project);
		return project;
	}

	
	/**
	 * 
	 * Method get issues list by param project
	 * @return Collection of issues 
	 * 
	 */
	@Override
	public Collection<Issue> getIssues(Project project) {
		List<Issue> issuesByProject = new ArrayList<>();
		for (Issue issue : issuesList) {
			if (issue.getProject().equals(project)) {
				issuesByProject.add(issue);

			}
		}
		return issuesByProject;
	}

	
	/**
	 * 
	 * Method get issues list by param project id
	 * @return Collection of issues 
	 * 
	 */
	@Override
	public Collection<Issue> getIssues(String id) {
		List<Issue> issuesByProjecId = new ArrayList<>();
			for (Project project : projectsList) {
			if (project.getId().equals(id)) {
				for (Issue issue : issuesList) {
					if (issue.getProject().equals(project)) {
						issuesByProjecId.add(issue);
					}
				}

			}
		}
		// List <Issue> issuesByProjecId = new ArrayList( Arrays.asList(issues.stream().filter(elem -> elem.getProject().getId().equals(id)).toArray()));
		
		return issuesByProjecId;
	}

	
	/**
	 * 
	 * Method get project by param project id
	 * @return project 
	 * 
	 */
	@Override
	public Project getProjectById(String id) {
		Project result = null;
		for (Project proj : projectsList) {
			if (proj.getId().equals(id)) {
				result = proj;
			}
		}
		return result;
	}

	/**
	 * 
	 * Method get all added projects
	 * @return Collection of projects 
	 * 
	 */
	@Override
	public Collection<Project> getProjects() {
		return projectsList;
	}
}
