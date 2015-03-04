package jdk8;

import java.util.Comparator;

public class VersionComparator implements Comparator<Version> {

	@Override
	public int compare(Version v1, Version v2) {
		//just consider major version
		String[] versions1 = v1.getVersion().split(".");
		String[] versions2 = v2.getVersion().split(".");
		
		if (versions1.length == 0 && versions2.length == 0) {
			return 0;
		}
		
		if (versions1.length == 0) {
			return 1;
		}
		
		if (versions2.length == 0) {
			return -1;
		}
		
		int majorVersion1 = Integer.parseInt(versions1[0]);
		int majorVersion2 = Integer.parseInt(versions2[0]);
		
		if (majorVersion1 == majorVersion2) {
			return 0;
		}
		
		if (majorVersion1 > majorVersion2) {
			return 1;
		}
		
		if (majorVersion1 < majorVersion2) {
			return -1;
		}
		
		return 0;
	}

}
