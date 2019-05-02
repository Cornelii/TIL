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



**Block**

```python
from datetime import datetime
from hashlib import sha256

class Block:
  def __init__(self, transactions, previous_hash, nonce = 0):
    self.timestamp = datetime.now()
    self.transactions = transactions
    self.previous_hash = previous_hash
    self.nonce = nonce
    self.hash = self.generate_hash()
    
  def print_block(self):
    # prints block contents
    print("timestamp:", self.timestamp)
    print("transactions:", self.transactions)
    print("current hash:", self.generate_hash())
    
  def generate_hash(self):
    # hash the blocks contents
    block_contents = str(self.timestamp)+str(self.transactions)+str(self.previous_hash)+str(self.nonce)
    block_hash = sha256(block_contents.encode())
    
    return block_hash.hexdigest()

```





**Block Chain**

BlockChain contains following three things.

1. Chain: A list that holds all the blocks inside the blockchain.
2. Unverified Transactions: A list that represents all the unverified transactions before being passed into a block.
3. Genesis Block: A block automatically generated when the blockchain is initialized.



```python
#imports the Block class from block.py
from block import Block

class Blockchain:
  def __init__(self):
    self.chain = []
    self.all_transactions = []
    self.genesis_block()

  def genesis_block(self):
    transactions = {}
    genesis_block = Block(transactions, "0")
    self.chain.append(genesis_block)
    return self.chain

  # prints contents of blockchain
  def print_blocks(self):
    for i in range(len(self.chain)):
      current_block = self.chain[i]
      print("Block {} {}".format(i, current_block))
      current_block.print_contents()    
  
  # add block to blockchain `chain`
  def add_block(self, transactions):
    previous_block_hash = self.chain[len(self.chain)-1].hash
    new_block = Block(transactions, previous_block_hash)
    # modify this method
    proof = self.proof_of_work(new_block)
    self.chain.append(new_block)
    return proof, new_block
    

  def validate_chain(self):
    for i in range(1, len(self.chain)):
      current = self.chain[i]
      previous = self.chain[i-1]
      if(current.hash != current.generate_hash()):
        print("The current hash of the block does not equal the generated hash of the block.")
        return False
      if(current.previous_hash != previous.generate_hash()):
        print("The previous block's hash does not equal the previous hash value stored in the current block.")
        return False
    return True
  
    def proof_of_work(self,block, difficulty=2):
    proof = block.generate_hash()
    while proof[:difficulty] != '0'*difficulty:
      block.nonce += 1
      proof = block.generate_hash()
    block.nonce = 0
    return proof
```





**Nonce and Proof-of-Works**

```python
new_transactions = [{'amount': '30', 'sender':'alice', 'receiver':'bob'},
               	{'amount': '55', 'sender':'bob', 'receiver':'alice'}]

# import sha256
from hashlib import sha256
# sets the amount of leading zeros that must be found in the hash produced by the nonce
difficulty = 2
nonce = 0

transactions_str = str(new_transactions)
target_str = transactions_str + str(nonce)
proof = sha256(target_str.encode()).hexdigest()
# creating the proof 

# printing proof
print(proof)

while proof[:2] != "00":
  nonce += 1
  target_str = transactions_str + str(nonce)
  proof = sha256(target_str.encode()).hexdigest()
  
  
final_proof = proof
  
# finding a proof that has 2 leading zeros


# printing final proof that was found
print(final_proof)
print(nonce)
```



**use of basic blockchain in local only!!**

```python
from blockchain import Blockchain

block_one_transactions = {"sender":"Alice", "receiver": "Bob", "amount":"50"}
block_two_transactions = {"sender": "Bob", "receiver":"Cole", "amount":"25"}
block_three_transactions = {"sender":"Alice", "receiver":"Cole", "amount":"35"}
fake_transactions = {"sender": "Bob", "receiver":"Cole, Alice", "amount":"25"}

local_blockchain = Blockchain()
local_blockchain.print_blocks()

local_blockchain.add_block(block_one_transactions)
local_blockchain.add_block(block_two_transactions)
local_blockchain.add_block(block_three_transactions)
local_blockchain.print_blocks()
print(local_blockchain.validate_chain())
local_blockchain.chain[2].transactions = fake_transactions

print(local_blockchain.validate_chain())
```

## VI. Alternatives of Proof-of-works

#### 1. Proof-of-Burn
The functioning of this method is easy. Here, instead of bringing the money together into computer equipment, the owner burns the coins. Here the coins to the address where they are irretrievable. By doing this, the owner gets a privilege to mine on the system. It works on random selection.

#### 2. Proof-of-Stake
The more coin you have, The better chance to be chosen?!
* To lead in the race of mining, the validator has to invest the coins of the system in case of Proof-Of-Stake.
* There is no coin creation when it comes to Proof-Of-Stake. Instead, the coins exist from the start, and the validators get a reward in the form of transaction fees.

#### 3. Proof-of-Capacity
The more is the hard drive space, the more is the probability of mining the next block and earning a reward.

In case of Proof-Of-Capacity, the algorithm generates plots. Plots are large data sets. These data set are stored on the hard drive. The more are the number of plots on the hard drive; better are the chances of finding the next block in the chain. Here one needs to invest in buying the hard drive space to enhance the chances of selection.

Proof-Of-Capacity is used only for Burstcoin as of now.

#### 4. Proof-of-Elapsed Time
This method has a drawback that here you need to rely on Intel which is again similar to entrusting a third party. But, this is the main point of concern, in case of cryptocurrency transaction we are avoiding the use of third party and Intel’s mechanism makes use of the third party.