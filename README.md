# springboot-rsocket-example
An example of building Spring Boot services using RSocket as the communication protocol.

The example contains two services which generate random numbers and letters. The client application calls the services and
streams back the randomly generated data for display in the console.

## Building the Example
Run the following command to build the example:

    ./gradlew clean build

## Running the Example
Follow the steps below to run the example:

1. Run the following command to start the `letter-service`:

        ./gradlew :letter-service:bootRun

2. In a new terminal, run the following command to start the `number-service`:

        ./gradlew :number-service:bootRun
        
3. In a new terminal, run the following command to start the `client`:

        ./gradlew :client:bootRun
        
    If successful, you will see numbers and letters generated in the console:
    
        2019-11-02 14:03:22.231  INFO 6001 --- [           main] example.client.Application               : Started Application in 1.058 seconds (JVM running for 1.33)
        2019-11-02 14:03:22.381  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: 828324521
        2019-11-02 14:03:22.381  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: y
        2019-11-02 14:03:22.382  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: -1445318175
        2019-11-02 14:03:22.382  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: p
        2019-11-02 14:03:22.383  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: 647963529
        2019-11-02 14:03:22.383  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: q
        2019-11-02 14:03:22.383  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: -1716932859
        2019-11-02 14:03:22.383  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: o
        2019-11-02 14:03:22.383  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: -801833868
        2019-11-02 14:03:22.383  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: f
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: -799458252
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: t
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: 719756754
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: v
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: -735566079
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: w
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: 401775378
        2019-11-02 14:03:22.384  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: d
        2019-11-02 14:03:22.385  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Number Received: 794028778
        2019-11-02 14:03:22.385  INFO 6001 --- [actor-tcp-nio-2] example.client.ClientCommandLineRunner   : Numbers Done!
        2019-11-02 14:03:22.385  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letter Received: z
        2019-11-02 14:03:22.385  INFO 6001 --- [actor-tcp-nio-1] example.client.ClientCommandLineRunner   : Letters Done!
    

        
## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/springboot-rsocket-example/issues).

## License
MIT License

Copyright (c) 2019 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
