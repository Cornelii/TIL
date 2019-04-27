# Block Chain

bank transaction : senders <=> bank <=> recipients

blockchain transaction: senders <=> receivers under public network of computers to verify the transaction

*In thie composition*,

each block in the blockchain : a transaction.



Block chain is just an accurate, and permanent record of all the transactions that have happend amongst the members in that blockchain's network.



**Key**

1. **Block**: A block is an individual transaction or piece of data that is being stored within the blockchain
2. **Blockchain**: A blockchain is a continuously growing list of records, called blocks, which are linked **chronologically** and secured using cryptography.



**decentralized**

<span style="color:blue; font-weight:bold">participants cross-reference their copy of the blockchain each time a new block is being introduced.</span>

In order for a new block to be added, 51% of all of the participants in the blockchain network must verify that the new block is not fraudulent. Once a block has been verified as a valid transaction, it is added to each participant’s copy of the blockchain.

By having the majority of participants validate a new transaction, the blockchain removes the need for a central authority and automates the completion of transactions, reducing transaction fees while ensuring a high level of security.

**Key**

1. **Blockchain Network**: Entire Blockchain
2. **Decentralization**: Concept in which participants work together to validate data without a central authority
3. **Participant**: A client that owns a copy of the blockchain and verifies transactions across the network.

## I. Blocks in Blockchain

A Block contains

1. transaction data(any information)
2. Timestamp(created)
3. current hash (by cryptographic hash function) (digital fingerprint)
4. previous hash

**Previous Hash**: Each block has a reference to the block prior to its hash.

* *This is what makes the blockchain **unique** because this link will be broken if a block is tampered with.*
* Each block has a reference to the block’s previous hash. This is how blocks are “chained” together.

#### i. Genesis block (first block of blockchain)

Since all blocks in the blockchain have a reference to the previous block, the first block is a little different than the rest. It is known as the *Genesis Block*.

Block does not have a block before it.

To resolve this issue, the value of the previous hash is typically hard-coded into the Genesis Block with the default value of zero.

## II. Hashing

1. Cryptographic hash function (in blockchain)
2. One-way
3. Deterministic (The same input produces the same output.)



**Key**

**Transactions**: An exchange of value among participants on the blockchain network.

**Unconfirmed**: state in which blocks and transactions are yet to be verified.



## III. How blocks are confirmed and added to blockchain

1.  A random participant broadcasts their block to the entire network.
2. If more than 51% of the participants agree with the block, a consensus has been reached, and the block is now said to be confirmed!



**Key**

**Consensus**: The process of agreeing to the transactions on the blockchain network

**Immutable**: Something whose records can't be changed.

**Trustless**: A feature of blockchain that states how the system doesn't rely on any participant to verify transactions.

## IV. Proof-of-Works

A security feature in blockchain to prevent attackers from easily taking over the blockchain



**Proof-Of-Works** does nothing more than introduce an additional security constraint.

(Generally, guessing problems with cryptographic hash function(sha256) changing Nonce)

**Miners**: Special participants who calculate the Proof-of-Work to mine new blocks.

**Nonce**: A number to be guessed by miners which wen combined with the block produces an acceptable hash.

The first miner to produce a proof broadcasts their unconfirmed block together with the correct nonce value. The rest of the network then verifies the calculation. If the majority of the participants agree, the Proof-of-Work for the block is now complete and the block has now been confirmed! The network then moves on to work on the next block.



The blockchain participants always consider the longest chain to be the correct one. If someone is able to create the longest chain of blocks (even if the blocks are fake), the network is forced to accept the new chain.

The reason for this is simple — the blockchain network assumes that the longest chain has the most amount of computational work done in finding the Proof-of-Work for each block. Therefore, it is reasonable for the network to think that the longest chain contains the most proven record of transactions.

If a dishonest participant decides to tamper with a block, they would have to solve the Proof-of-Work for each subsequent block in order to introduce the tampered block into the network. This is computationally infeasible and almost impossible!

A block gets increasingly more tamper-proof as newer blocks are added next to it. Proof-of-Work makes it hard to get through the entire blockchain and allow someone to introduce a fake transaction.

**Key**
**Longest Chain:** The most trusted chain with the largest amount of computational work done in calculating the Proof-of-Work.





## V. BlockChain in Python

