package lt.vtvpmc.ems.akademijait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.sun.istack.internal.logging.Logger;

import lt.vtvpmc.java.postoffice.IllegalPackageException;
import lt.vtvpmc.java.postoffice.Package;
import lt.vtvpmc.java.postoffice.PostOffice;

/**
 * 
 * @author daiva The post office
 *
 */
public class MyPostOffice implements PostOffice {
	final static Logger logger = Logger.getLogger(MyPostOffice.class);
	private Collection<Package> packageList = new ArrayList<Package>();

	/**
	 * Counts the number of packages owned by the owner currently in the PostOffice.
	 * 
	 * @param owner
	 * 
	 */
	@Override
	public long numberOfPackagesForOwner(String owner) {
		long numberOfPackagesForOwner = packageList.stream().filter(pkg -> pkg.getOwner().equals(owner))
				.collect(Collectors.toList()).size();
		logger.info(
				"The number of packages owned by the owner currently in the PostOffice is " + numberOfPackagesForOwner);
		return numberOfPackagesForOwner;
	}

	/**
	 * Posting the package adds it to PostOffice inventory. Once in the inventory
	 * package can be retrieved. Packages without a package code or owner should not
	 * be allowed to be posted. Not having package code or owner is having those
	 * values set to null or an empty string.
	 * 
	 * @throws IllegalArgumentException
	 * @param pkg
	 */

	@Override
	public void postPackage(Package pkg) throws IllegalPackageException {
		if (pkg.getOwner() == null || pkg.getPackageCode() == (null) || pkg.getPackageCode().equals("")
				|| pkg.getOwner().equals("")) {
			logger.info(
					"Packages without a package code or owner should not be allowed to be posted. Not having package code or owner is having those values set to null or an empty string.");
			throw new IllegalPackageException();
		} else {
			logger.info("The package " + pkg + " adds it to PostOffice inventory");
			packageList.add(pkg);
		}
	}

	/**
	 * Package retrievePackage(String packageCode) Retrieves a package from
	 * PostOffice. PostOffice will remove the package from its inventory before
	 * returning it. Parameters: packageCode - packageCode Returns: package removed
	 * from PostOffice inventory, null if package is not found
	 * 
	 * @param packageCode
	 * @return Package
	 */

	@Override
	public Package retrievePackage(String packageCode) {
		Package returningPackage = null;
		for (Package pkg : packageList) {
			if (pkg.getPackageCode().equals(packageCode)) {
				returningPackage = pkg;
				packageList.remove(pkg);
				logger.info("PostOffice removed the package " + pkg);
				break;
			}
		}
		logger.info("Retrieves a package from PostOffice " + returningPackage);
		return returningPackage;
	}
}
