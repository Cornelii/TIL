# Google Cloud API

## I. Google Cloud Speech API: Qwik Start

At the cloud shell

#### 1. Getting account info
> gcloud auth list

#### 2. list the project ID
> gcloud config list project


#### 3. Create An API KEY
At APIs&Services > Credentials > Create credentials > API keys

> export API_KEY=<YOUR_API_KEY>


#### 4. Create your Speech API request

> touch request.json
using nano, vim, emacs, or gcloud
```json
{
  "config": {
      "encoding":"FLAC",
      "sample_rate": 16000,
      "language_code": "en-US"
  },
  "audio": {
      "uri":"gs://cloud-samples-tests/speech/brooklyn.flac"
  }
}
```

The request body has a config and audio object.

In config, you tell the Speech API how to process the request:

The encoding parameter tells the API which type of audio encoding you're using while the file is being sent to the API. FLAC is the encoding type for .raw files (here is documentation for encoding types for more details).
sample_rate is the rate in Hertz of the audio data you're sending to the API.
There are other parameters you can add to your config object, but encoding and sample_rate are the only required ones.

In the audio object, you pass the API the uri of the audio file in Cloud Storage.

Now you're ready to call the Speech API!

#### 5. Call the Speech API
on console copy and paste the below ones at oneline

curl -s -X POST -H "Content-Type: application/json" --data-binary @request.json \
"https://speech.googleapis.com/v1beta1/speech:syncrecognize?key=${API_KEY}"


## II. Cloud Natural Language API:Qwik Start
At the cloudshell

#### 1. Set an environment variable
> export GOOGLE_CLOUD_PROJECT=$(gcloud config get-value core/project)

#### 2. create a new service account to access tha NLP API.
> gcloud iam service-accounts create my-natlang-sa \
  --display-name "my natural language service account"


#### 3. Create credentials to log in. (save it as a JSON file)
> gcloud iam service-accounts keys create ~/key.json \
  --iam-account my-natlang-sa@${GOOGLE_CLOUD_PROJECT}.iam.gserviceaccount.com

#### 4. GOOGLE_APPLICATION_CREDENTIALS environment variable
> export GOOGLE_APPLICATION_CREDENTIALS="/home/USER/key.json"


#### 5. gcloud command
> gcloud ml language analyze-entities --content="Michelangelo Caravaggio, Italian painter, is known for 'The Calling of Saint Matthew'."



## III. Speech to Text Transcription with the Cloud Speech API


At the cloud shell
#### 1. api_key
> export API_KEY=<YOUR_API_KEY>


#### 2. Create your Speech API request
> touch request.json

```json
{
  "config": {
      "encoding":"FLAC",
      "languageCode": "en-US"
  },
  "audio": {
      "uri":"gs://cloud-samples-tests/speech/brooklyn.flac"
  }
}
```

#### 3. Call the Speech API

> curl -s -X POST -H "Content-Type: application/json" --data-binary @request.json \
"https://speech.googleapis.com/v1/speech:recognize?key=${API_KEY}"




## IV. Entity and Sentiment Analysis with the Natural Language API

#### 1.
1. assign your API_KEY as an environment variable at the cloud shell

2. create requset.json
```json
{
  "document":{
    "type":"PLAIN_TEXT",
    "content":"Joanne Rowling, who writes under the pen names J. K. Rowling and Robert Galbraith, is a British novelist and screenwriter who wrote the Harry Potter fantasy series."
  },
  "encodingType":"UTF8"
}

```

3. Call the NLP API using curl on the cloud shell
> curl "https://language.googleapis.com/v1/documents:analyzeEntities?key=${API_KEY}" \
  -s -X POST -H "Content-Type: application/json" --data-binary @request.json


  5. Sentiment analysis with the NLP API
with request as follows
```json
 {
  "document":{
    "type":"PLAIN_TEXT",
    "content":"Harry Potter is the best book. I think everyone should read it."
  },
  "encodingType": "UTF8"
}
```

> curl "https://language.googleapis.com/v1/documents:analyzeSentiment?key=${API_KEY}" \
  -s -X POST -H "Content-Type: application/json" --data-binary @request.json

  #### 2. Analyzing entity sentiment
  request
  ```json
 {
  "document":{
    "type":"PLAIN_TEXT",
    "content":"I liked the sushi but the service was terrible."
  },
  "encodingType": "UTF8"
}
  ```

  > curl "https://language.googleapis.com/v1/documents:analyzeEntitySentiment?key=${API_KEY}" \
  -s -X POST -H "Content-Type: application/json" --data-binary @request.json

  #### 3. Analyzing syntax and parts of speech

  request
  ```json
{
  "document":{
    "type":"PLAIN_TEXT",
    "content": "Joanne Rowling is a British novelist, screenwriter and film producer."
  },
  "encodingType": "UTF8"
}

  ```
> curl "https://language.googleapis.com/v1/documents:analyzeSyntax?key=${API_KEY}" \
  -s -X POST -H "Content-Type: application/json" --data-binary @request.json


  #### 4. Multilingual natural language processing

  request
  ```json
{
  "document":{
    "type":"PLAIN_TEXT",
    "content":"日本のグーグルのオフィスは、東京の六本木ヒルズにあります"
  }
}
  ```

  >  curl "https://language.googleapis.com/v1/documents:analyzeEntities?key=${API_KEY}" \
  -s -X POST -H "Content-Type: application/json" --data-binary @request.json

