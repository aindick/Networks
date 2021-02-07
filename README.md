# Networks
This is the first assignment for Computer Networks CSC 455 at SUNY Oswego.

Measure the latency and throughput of TCP and/or UDP (as noted below) across at least three pairs of machines using at least two different networks. For example, two CS servers (like wolf and pi), or a CS server to a laptop, wired or wireless, or off-campus. Create a web page with graphs summarizing your results. All messages must use xor encoding of 64bit (8 byte) values, based on a (possibly random) key. Include the following measurements:
   
    -Measure round-trip latency as a function of message size, by sending and receiving (echoing and validating) messages of size 8, 64, 256, and 1024 bytes, using TCP. Measure RTTs.
    -The same as (1), except using UDP.
    -Measure throughput by sending TCP messages of size 1K, 64K, and 1M bytes in each direction. Measure transfer rates.
    -Measure the interaction between message size and number of messages using TCP and UDP by sending 1MByte of data (with a 8-byte acknowledgment in the reverse direction) using different numbers of messages: 1024 1024Byte messages, vs 2048 512Byte messages, vs 4096 X 256Byte messages.
    -The same as (4), using UDP.
