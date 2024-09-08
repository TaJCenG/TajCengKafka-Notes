WHAT IS KAFKA ?

ANS : KAFKA IS A DISTRIBUTED COMMIT LOG, AS EVENTS HAPPEN IN MICROSERVICE APPLICATION, THE APPLICATIONS PUT THESE EVENTS ONTO A LOG 
      APACHE KAFKA IS A SYSTEM FOR MANAGING THESE LOGS. THE TERM FOR THE LOGS IS "TOPIC".
 
    KAFKA STORES THE EVENTS IN ORDERLY FASHION AND IT ALSO WRITES THOSE TO A DISC NOT 1 DISC IT CAN REPLICATE THEM ACROSS DISKS TO ENSURE THAT THE
    MESSAGES OR EVENTS ARE NOT LOST.
   MICROSERVICE APPLICATION EXCHANGE EVENTS THROUGH THESE TOPICS OR STREAMS IN REAL TIME
   DATA AND EVENT CAN BE PROCESSED ASA THEY PRODUCED.
EACH MICROSERVICE HAVE THEIR OWN PROCESSING LOGIC, THEY DEFINE OWN COMPUTATIONAL LOGIC
MICROSERVICE APPLICATION  NEEDS TO GROUP DATA FILTER THEM JOIN THEM AGGREGATE WITH HLEP OF STRAMING API
KAFKA GIVES STREAMING API WHICH IS SUPER SIMPLETO USE AND WILL BE ABLE TO DO OUT OF THE BOX IN MICROSERVICE USING KAFKA STREAMING API   
 
KAFKA HAS OWN DATABASE "KAFKA CONNECT" TO CONNECT TO ANY DATABASE WITHOUT WRITING ANY CODE
----------------------------------------------------------------------------------------------------------------------------------------------------	           
WHY KAFKA?

ANS: IT PRODUCES MULTIPLE PRODUCERS AND CONSUMERS
     MULTIPLE PRODUCERS WRITE TO A SINGLE TOPIC AT SAME TIME AND MULTIPLE CONSUMER CAN SUBSCRIBE AT A SAME TIME FROM SAME TOPIC
	 REDEEMS THE MESSAGE WITHOUT LOSING IT AND OTHER CONSUMER CAN USE INTS OWN WAY
	 SUPPORTS CONSUMER GROUPS AND PARTITIONS
	 DISK BASED PERSISTNECE ( DATA STORING IF CONSUMER IS DOWN WITH A PRECONFIGURABLE OF TIME AND THE CONSUMER CAN GET THE MESSAGE WHEN ITS READY)
	 GOOD SCALABILITY
----------------------------------------------------------------------------------------------------------------------------------------------------	           	 
KAFKA ARCHITECTURE

ANS: BROKER   ZOOKEEPER   PRODUCER   CONSUMER
     THE KAFKA CLUSTER IS A COLLECTIONS OF KAFKA BROKER ALSO REFERRED AS KAFKA SERVERS OR NODES
	BROKER: MESSAGES EXCHANGED BETWEEN THE PRODUCER AND CONSUMER, THE BROKER NOT ONLY DECOUPLES THE PRODUCER AND CONSUMER BUT IT ALSO ENSURES THAT
	        THE MESSAGES ARE PERSISTNECEAND DURABLE.
	THE KAFKA BROKER IS A JAVA PROCESS AND WE CAN INCREASE THE NUMBER OF BROKERS TO PROVIDE SCALABILITY AND DURABILITY OF MESSAGES
	ONE OF THE BROKERS WILL ELECTED AS LEADER OR CLUSTER CONTROLLER AND ALL THE BROKERS FOLLOW THESE LEADERS
	ZOOKEEPER : RESPONSIBLE FOR ELECTING CLUSTER LEADER 
	            ALL THE BROKER NODES WILL REGISTER THEM SELVES WITH THE ZOOKEEPER COMPONENT WHEN THEY COME UP WITH AND THE ZOOKEEPER WILL PICK ONLY
				ONE OF THE BROKERS AS THE CLUSTER LEADER AND IF THER BROKER GOES DOWN WILL PICK OTHER AS LEADER
				IT ALSO MANTAINS THE STATES OF BROKERS
	PRODUCER : PRODUCER IS AN APPLICATION  WHICH PRODUCED THE DATA  
	           COMMUNICATES WITH CLUSTER USING THE TCP PROTOCOL AND THEY CONNECT WITH THE BROADCAST DIRECTLY AND START SENDING MESSAGES TO THEIR TOPIC
			   CAN SEND MESSAGE TO MULTIPLE TOPICS AND A TOPIC RECEIVES MESSAGES FROM MULTIPLE PRODUCERS 
	CONSUMER : WHICH CONSUMERS THE DATA FROM ONE OR MORE TOPICS AND PROCESS 
	           COORDINATE AMONG THEM SELVES AS A GROUP TO BALANCE THE LOAD AND ALSO TRACK EACH OTHER PROGRESS SO THEY DO AL LOT MORE WORK WHEN 
			   COMPARED TO PRODUCER
			   A CONSUMER GROUP IS A SET OF CONSUMERS WORKING TOGETHER TO CONSUME A TOPIC.
               A CONSUMER GROUP ENSURES THAT EACH PARTITION IS CONSUMED BY ONLY ONE CONSUMER.
----------------------------------------------------------------------------------------------------------------------------------------------------	           
KAFKA RECORD    https://kafka.apache.org/23/javadoc/org/apache/kafka/clients/producer/ProducerRecord.html
ANS : PRODUCER APPLICATION CREATE AND EXCHANGE DATA USING RECORD IN KAFKA			   
      7 ATTRIBUTES TO A RECORD : TOPIC :: PARTITIONS :: OFFSET :: TIMESTAMP :: KEY :: HEADERS :: VALUE
	  METADATA TO EXCHANGE DATA   

 
THE PRODUCER APPLICATIONS CREATE AND EXCHANGE DATA USING A RECORD IN KAFKA. 
THERE ARE SEVEN ATTRIBUTES TO A RECORD, STARTING WITH TOPIC, PARTITION, OFFSET, TIMESTAMP, KEY, HEADERS AND FINALLY THE VALUE. 
TOPIC : The topic is the topic to which this record should be returned to 
PARTITION : PARTITION IS A ZERO BASED INDEX TO WHICH THE RECORD SHOULD BE WRITTEN. 
                     A RECORD IS ALWAYS ASSOCIATED WITH ONLY ONE PARTITION, AND THE PARTITION NUMBER CAN BE SET BY THE PRODUCER APPLICATION. 
                     AND IF IT IS NOT SET, IT WILL BE CALCULATED BASED ON THE KEY THAT IS PROVIDED IN THE RECORD. 
                    A HASH VALUE WILL BE CALCULATED BY USING THE KEY VALUE AND THE RESULT WILL BE USED AS THE PARTITION 
                    NUMBER TO WHICH THAT RECORD SHOULD GO TO. 
			
OFFSET : THE OFFSET, WHICH IS A 64 BIT SIGNED INTEGER FOR LOCATING THE RECORD WITHIN A PARTITION. 
TIMESTAMP : THE TIME STAMP CAN BE SET BY THE PRODUCER APPLICATION, AND IF IT IS NOT SET, THEN THE PRODUCER API 
                           INTERNALLY ASSIGNS THE CURRENT TIME AS THE TIME STAMP. 
KEY : THE KEY, ALTHOUGH IT IS CALLED A KEY, IT IS AN OPTIONAL NON-UNIQUE VALUE, IT IS A ARRAY OF BYTES. 
           A KEY VALUE YOU PRESENT WILL BE USED TO CALCULATE THE PARTITION NUMBER. 
           A HASH ALGORITHM WILL BE USED ALONG WITH THIS. 
          THE VALUE OF THE KEY AND THE PARTITION NUMBER WILL BE CALCULATED TO WHICH THE RECORD SHOULD GO TO. 
          IF THE KEY VALUE IS NOT SET BECAUSE IT IS OPTIONAL, THEN THE KAFKA WILL DECIDE THE PARTITION NUMBER IN A ROUND-ROBIN FASHION. 

HEADERS : THE HEADERS, WHICH IS OPTIONAL KEY VALUE PAIRS, JUST LIKE THE HTTP HEADERS TO PASS IN METADATA. 
VALUE :  THIS IS WHERE THE PAYLOAD FOR OUR MESSAGE LIES. 
         IT IS A ARRAY OF BYTES. 
         IT IS THE ONE THAT CONTAINS OUR BUSINESS DATA, ALTHOUGH THE VALUE IS ALSO OPTIONAL. 
         WITHOUT IT, THE RECORD DOESN'T MAKE ANY SENSE. 
         SO ALL THE OTHER ATTRIBUTES ARE LIKE METADATA FOR THIS DATA WE ARE EXCHANGING USING THE VALUE ATTRIBUTE 
----------------------------------------------------------------------------------------------------------------------------------------------------	         	           
TOPICS PARTITIONS OFFSETS :
ANS :   MESSAGES IN KAFKA ARE RETURNEDTO A TOPIC, AND EACH TOPIC CAN BE DIVIDED INTO ONE OR MORE PARTITIONS.	 
        IF KAFKA IS A DISTRIBUTED MESSAGING OR COMMIT LOG, THEN A PARTITION IS A SINGLE LOG OF MESSAGES OR RECORDS.
		MESSAGES ARE APPENDED TO THE END OF A PARTITION AS THEY COME IN.
		EACH PARTITION WILL HAVE A LEADER AND A FOLLOWER.
		ONLY IF THE OTHER BROKER, WHICH IS THE LEADER, GOES DOWN, THESE BROKERS WILL BECOME THE LEADER FOR THAT PARTITION AS WELL.IT'S LIKE A BACKUP.
		KAFKA ASSIGNS EACH PARTITION A UNIQUE NUMBER AND ALSO EACH MESSAGE OR A RECORD THAT IS STORED WITHIN A PARTITION GETS THE OFFSET VALUE.
		THE MESSAGING ORDER ACROSS PARTITIONS IS NOT GUARANTEED,WHEREAS THE MESSAGING ORDER WITHIN A PARTITION IS MAINTAINED, THE PRODUCER APPLICATION CAN SPECIFY
        WHICH PARTITION THE MESSAGE SHOULD GO INTO USING THE PARTITION NUMBER.
		KAFKA WILL TAKE THAT PARTITION NUMBER AND PUT THE MESSAGE INTO THAT PARTITION. IF NOT, IT CAN GIVE YOU A KEY.
		Instead of putting all the partitions in one Broker, we can scale them across Brokers' here
        I HAVE FOUR PARTITIONS ON THREE BROCKERS. THIS WILL INCREASE THE PERFORMANCE AND THE APPLICATION CAN BE EASILY SCALED. 
		ALONG WITH THIS PARTITIONS ALSO SUPPORT REPLICATION OR DUPLICATION, WHICH GIVE HIGH AVAILABILITY, 
----------------------------------------------------------------------------------------------------------------------------------------------------	           	           		
 
BATCHING 
ANS : KAFKA producers won't send one message at a time to the Kafka Broker instead they Batch them based on the topic and partition
      to which they have to go to a batch, is a collection of messages that should be returned to that same topic and partition.	
	  THE larger the batch size, the more messages that will be processed in a given timeframe.
----------------------------------------------------------------------------------------------------------------------------------------------------	           	           			  
 
HOW TO START KAFKA SERVER 
ANS : 1. ZOOKEEPER-SERVER-START <<PATH OF ZOOKEEPER PROPERTIES>>
      2. KAFKA-SERVER-START  <<PATH OF THE KAFKA SERVER PROPERTIES>>
---------------------------------------------------------------------------------------------------------------------------------------------------------
 
KAFKA COMMAND LINE
ANS: 1. kafka-topics --list --bootstrap-server localhost:9092  TO SEE THE EXISTING TOPICS
     2. kafka-topics --create --replication-factor 1 -partitions 1 --topic <topicName> --bootstrap-server localhost:9092  TO CRETAE NEW TOPIC
	 3. kafka-topics --describe --topic <topicName>--bootstrap-server localhost:9092  TO KNOW MORE ABOUT THE PARTICULAR TOPICS
	 4. kafka-topics --delete --bootstrap-server localhost:9092  --topic <topicName> TO delete THE PARTICULAR TOPICS
	 PRODUCER AND CONSUMER IN CONSOLE
	 1.kafka-console-producer --broker-list localhost:9092 --topic <topicName>
	 2.kafka-console-consumer --broker-list localhost:9092 --topic <topicName>
---------------------------------------------------------------------------------------------------------------------------------------------------------
 
 MORE ABOUT KAFKA
 
 https://docs.confluent.io/kafka/overview.html
 
 https://developer.confluent.io/confluent-tutorials/kafka-producer-application/kafka/
 
 https://www.youtube.com/playlist?list=PLa7VYi0yPIH2PelhRHoFR5iQgflg-y6JA
---------------------------------------------------------------------------------------------------------------------------------------------------------
KAFKA PRODUCER FLOW

ANS : PRODUCER_RECORD : We create a producer record on which we can set various attributes, mainly the topic and the value, 
                                                   which is the payload. Optionally, we can set the partition timestamp key and headers once we have a producer record, 
	                                       will invoke the send method on the producer.
 
(send) -> SERIALIZER : The serializer will look for the key and value in the record and it will convert them from our Java types into byte arrays.
                                        Kafka has several inbuilt serializes that can work with common types in Java.

(send) -> PARTITONER : The partitioner checks if the record has a partition number. If the partition number is that it will use that as the 
                                             partition that the record should go into. If not, it will use the value of the key and a hashing algorithm to calculate the 
			             partition number. Even if the key is not present, then a partition number will be assigned in a Round-Robin fashion.
				 At this point, the producer knows the which partition the record should go to.
 
(send) -> TOPIC 1&2 : It will add the records to the batch that should go to a particular topic and partition.
                                        And a separate thread will pick up these batches and send them to that Kafka broker and the broker receives
                                          the message and successfully writes it to Kafka. We get a record metadata back if the right was successful and 
	                               if the broker fails for some reason we get that failure back. At this point, the producer can retry multiple times to 
			 send the message again to that topic and partition.If it keeps failing after some time, it will give up and throw the exception.
                                  So all this happens within the producer, the serialization of the key and value, then the partitioner taking care 
			of which partition the record should go into putting those into batches.
		 AND THEN A SEPARATE THREAD WITHIN THE PRODUCER API WILL PICK UP THAT BATCH AND SEND IT TO THE KAFKA
                      BROKER , WHICH SIMPLY TAKES THE MESSAGE, WRITES IT TO THE APPROPRIATE PARTITION WITHIN A TOPIC.
---------------------------------------------------------------------------------------------------------------------------------------------------------

Created a simple Java application With producer and consumer
TaJCenG/TajCengKafka-Notes: Explained about kafka with notes and examples programs (github.com)
![image](https://github.com/user-attachments/assets/7a85858c-9c55-4636-a658-4a6cd2e9cd36)
