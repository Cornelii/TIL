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