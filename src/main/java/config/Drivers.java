package config;

import java.io.File;

import static java.io.File.separator;

public class Drivers {

    private String getOSName() {
        return System.getProperty("os.name");
    }

    private String getOSArch() {
        return System.getProperty("os.arch");
    }

    private String getProjectDirectory() {
        String userDir =  System.getProperty("user.dir");
        if (userDir.contains("jenkins-test")) {
            return userDir.replace("/src/test", "");
        } else {
            return userDir;
        }
    }

    private String getOSDriverDirectory() {
        String os = getOSName().toLowerCase();
        if (os.contains("windows")) {
            return "windows";
        } else if (os.contains("linux")) {
            return "linux";
        } else {
            System.out.println("Current device OS is not included in the written project.");
            return "rien";
        }
    }

    public String getDriverPath(char browser) {
        String osArch = getOSArch();
        String os = getOSDriverDirectory();
        System.out.println(System.getProperty("user.dir"));
        System.out.println(getProjectDirectory());
        String driverDirectory = getProjectDirectory() + separator + "src" + separator + "main" + separator + "resources"
                + separator + "webdrivers" + separator + os + separator;
        if (os.equals("linux")) {
            switch (browser) {
                case 'F':
                    if (osArch.contains("64")) {
                        return driverDirectory + "geckodriver-v0.21.0-linux64";
                    } else if (osArch.contains("32") || osArch.contains("86")) {
                        return driverDirectory + "geckodriver-v0.21.0-linux32";
                    }
                case 'C':
                    return driverDirectory + "chromedriver-v2.40-linux64";
                case 'O':
                    return driverDirectory + "operadriver-v2.36-linux64";
                default:
                    System.out.println("");
                    return "rien";
            }
        } else if (os.equals("windows")) {
            switch (browser) {
                case 'F':
                    return driverDirectory + "geckodriver-v0.21.0-win64.exe";
                case 'C':
                    return driverDirectory + "chromedriver-v2.40-win32.exe";
                case 'O':
                    if (osArch.contains("64")) {
                        return driverDirectory + "operadriver-v2.36-win64.exe";
                    } else if (osArch.contains("32") || osArch.contains("86")) {
                        return driverDirectory + "operadriver-v2.36-win32.exe";
                    }
                case 'E':
                    return driverDirectory + "edgedriver-v17134.exe";
                case 'I':
                    if (osArch.contains("64")) {
                        return driverDirectory + "iedriver-v3.9.0-win64.exe";
                    } else if (osArch.contains("32") || osArch.contains("86")) {
                        return driverDirectory + "iedriver-v3.9.0-win32.exe";
                    }
                default:
                    System.out.println("");
                    return "rien";
            }
        } else {
            return "rien";
        }
    }
}