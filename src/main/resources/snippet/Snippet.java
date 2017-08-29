package snippet;

public class Snippet {
	# Root logger option
	log4j.rootLogger=DEBUG, stdout, file
	
	# Redirect log messages to console
	log4j.appender.stdout=org.apache.log4j.ConsoleAppender
	log4j.appender.stdout.Target=System.out
	log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
	log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
	
	# Redirect log messages to a log file
	log4j.appender.file=org.apache.log4j.RollingFileAppender
	#outputs to Tomcat home
	log4j.appender.file.File=${catalina.home}/logs/myapp.log
	log4j.appender.file.MaxFileSize=5MB
	log4j.appender.file.MaxBackupIndex=10
	log4j.appender.file.layout=org.apache.log4j.PatternLayout
	log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
}

