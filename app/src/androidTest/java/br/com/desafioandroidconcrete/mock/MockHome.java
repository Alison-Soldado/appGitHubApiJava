package br.com.desafioandroidconcrete.mock;

/**
 * Created by alison on 27/09/17.
 */

public interface MockHome {

    String SUCCESS = "{\n" +
            "    \"total_count\": 3658432,\n" +
            "    \"incomplete_results\": false,\n" +
            "    \"items\": [\n" +
            "        {\n" +
            "            \"id\": 7508411,\n" +
            "            \"name\": \"RxJava\",\n" +
            "            \"full_name\": \"ReactiveX/RxJava\",\n" +
            "            \"owner\": {\n" +
            "                \"login\": \"ReactiveX\",\n" +
            "                \"id\": 6407041,\n" +
            "                \"avatar_url\": \"https://avatars1.githubusercontent.com/u/6407041?v=4\",\n" +
            "                \"gravatar_id\": \"\",\n" +
            "                \"url\": \"https://api.github.com/users/ReactiveX\",\n" +
            "                \"html_url\": \"https://github.com/ReactiveX\",\n" +
            "                \"followers_url\": \"https://api.github.com/users/ReactiveX/followers\",\n" +
            "                \"following_url\": \"https://api.github.com/users/ReactiveX/following{/other_user}\",\n" +
            "                \"gists_url\": \"https://api.github.com/users/ReactiveX/gists{/gist_id}\",\n" +
            "                \"starred_url\": \"https://api.github.com/users/ReactiveX/starred{/owner}{/repo}\",\n" +
            "                \"subscriptions_url\": \"https://api.github.com/users/ReactiveX/subscriptions\",\n" +
            "                \"organizations_url\": \"https://api.github.com/users/ReactiveX/orgs\",\n" +
            "                \"repos_url\": \"https://api.github.com/users/ReactiveX/repos\",\n" +
            "                \"events_url\": \"https://api.github.com/users/ReactiveX/events{/privacy}\",\n" +
            "                \"received_events_url\": \"https://api.github.com/users/ReactiveX/received_events\",\n" +
            "                \"type\": \"Organization\",\n" +
            "                \"site_admin\": false\n" +
            "            },\n" +
            "            \"private\": false,\n" +
            "            \"html_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
            "            \"description\": \"RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.\",\n" +
            "            \"fork\": false,\n" +
            "            \"url\": \"https://api.github.com/repos/ReactiveX/RxJava\",\n" +
            "            \"forks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/forks\",\n" +
            "            \"keys_url\": \"https://api.github.com/repos/ReactiveX/RxJava/keys{/key_id}\",\n" +
            "            \"collaborators_url\": \"https://api.github.com/repos/ReactiveX/RxJava/collaborators{/collaborator}\",\n" +
            "            \"teams_url\": \"https://api.github.com/repos/ReactiveX/RxJava/teams\",\n" +
            "            \"hooks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/hooks\",\n" +
            "            \"issue_events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/events{/number}\",\n" +
            "            \"events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/events\",\n" +
            "            \"assignees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/assignees{/user}\",\n" +
            "            \"branches_url\": \"https://api.github.com/repos/ReactiveX/RxJava/branches{/branch}\",\n" +
            "            \"tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/tags\",\n" +
            "            \"blobs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/blobs{/sha}\",\n" +
            "            \"git_tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/tags{/sha}\",\n" +
            "            \"git_refs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/refs{/sha}\",\n" +
            "            \"trees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/trees{/sha}\",\n" +
            "            \"statuses_url\": \"https://api.github.com/repos/ReactiveX/RxJava/statuses/{sha}\",\n" +
            "            \"languages_url\": \"https://api.github.com/repos/ReactiveX/RxJava/languages\",\n" +
            "            \"stargazers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/stargazers\",\n" +
            "            \"contributors_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contributors\",\n" +
            "            \"subscribers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscribers\",\n" +
            "            \"subscription_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscription\",\n" +
            "            \"commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/commits{/sha}\",\n" +
            "            \"git_commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/commits{/sha}\",\n" +
            "            \"comments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/comments{/number}\",\n" +
            "            \"issue_comment_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/comments{/number}\",\n" +
            "            \"contents_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contents/{+path}\",\n" +
            "            \"compare_url\": \"https://api.github.com/repos/ReactiveX/RxJava/compare/{base}...{head}\",\n" +
            "            \"merges_url\": \"https://api.github.com/repos/ReactiveX/RxJava/merges\",\n" +
            "            \"archive_url\": \"https://api.github.com/repos/ReactiveX/RxJava/{archive_format}{/ref}\",\n" +
            "            \"downloads_url\": \"https://api.github.com/repos/ReactiveX/RxJava/downloads\",\n" +
            "            \"issues_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues{/number}\",\n" +
            "            \"pulls_url\": \"https://api.github.com/repos/ReactiveX/RxJava/pulls{/number}\",\n" +
            "            \"milestones_url\": \"https://api.github.com/repos/ReactiveX/RxJava/milestones{/number}\",\n" +
            "            \"notifications_url\": \"https://api.github.com/repos/ReactiveX/RxJava/notifications{?since,all,participating}\",\n" +
            "            \"labels_url\": \"https://api.github.com/repos/ReactiveX/RxJava/labels{/name}\",\n" +
            "            \"releases_url\": \"https://api.github.com/repos/ReactiveX/RxJava/releases{/id}\",\n" +
            "            \"deployments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/deployments\",\n" +
            "            \"created_at\": \"2013-01-08T20:11:48Z\",\n" +
            "            \"updated_at\": \"2017-09-27T19:42:42Z\",\n" +
            "            \"pushed_at\": \"2017-09-27T07:42:16Z\",\n" +
            "            \"git_url\": \"git://github.com/ReactiveX/RxJava.git\",\n" +
            "            \"ssh_url\": \"git@github.com:ReactiveX/RxJava.git\",\n" +
            "            \"clone_url\": \"https://github.com/ReactiveX/RxJava.git\",\n" +
            "            \"svn_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
            "            \"homepage\": \"\",\n" +
            "            \"size\": 43516,\n" +
            "            \"stargazers_count\": 27556,\n" +
            "            \"watchers_count\": 27556,\n" +
            "            \"language\": \"Java\",\n" +
            "            \"has_issues\": true,\n" +
            "            \"has_projects\": true,\n" +
            "            \"has_downloads\": true,\n" +
            "            \"has_wiki\": true,\n" +
            "            \"has_pages\": true,\n" +
            "            \"forks_count\": 4851,\n" +
            "            \"mirror_url\": null,\n" +
            "            \"open_issues_count\": 35,\n" +
            "            \"forks\": 4851,\n" +
            "            \"open_issues\": 35,\n" +
            "            \"watchers\": 27556,\n" +
            "            \"default_branch\": \"2.x\",\n" +
            "            \"score\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 507775,\n" +
            "            \"name\": \"elasticsearch\",\n" +
            "            \"full_name\": \"elastic/elasticsearch\",\n" +
            "            \"owner\": {\n" +
            "                \"login\": \"elastic\",\n" +
            "                \"id\": 6764390,\n" +
            "                \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
            "                \"gravatar_id\": \"\",\n" +
            "                \"url\": \"https://api.github.com/users/elastic\",\n" +
            "                \"html_url\": \"https://github.com/elastic\",\n" +
            "                \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
            "                \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
            "                \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
            "                \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
            "                \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
            "                \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
            "                \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
            "                \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
            "                \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
            "                \"type\": \"Organization\",\n" +
            "                \"site_admin\": false\n" +
            "            },\n" +
            "            \"private\": false,\n" +
            "            \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
            "            \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
            "            \"fork\": false,\n" +
            "            \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
            "            \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
            "            \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
            "            \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
            "            \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
            "            \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
            "            \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
            "            \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
            "            \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
            "            \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
            "            \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
            "            \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
            "            \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
            "            \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
            "            \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
            "            \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
            "            \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
            "            \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
            "            \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
            "            \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
            "            \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
            "            \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
            "            \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
            "            \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
            "            \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
            "            \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
            "            \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
            "            \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
            "            \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
            "            \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
            "            \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
            "            \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
            "            \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
            "            \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
            "            \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
            "            \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
            "            \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
            "            \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
            "            \"updated_at\": \"2017-09-27T18:51:51Z\",\n" +
            "            \"pushed_at\": \"2017-09-27T19:02:09Z\",\n" +
            "            \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
            "            \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
            "            \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
            "            \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
            "            \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
            "            \"size\": 371007,\n" +
            "            \"stargazers_count\": 25429,\n" +
            "            \"watchers_count\": 25429,\n" +
            "            \"language\": \"Java\",\n" +
            "            \"has_issues\": true,\n" +
            "            \"has_projects\": true,\n" +
            "            \"has_downloads\": true,\n" +
            "            \"has_wiki\": false,\n" +
            "            \"has_pages\": false,\n" +
            "            \"forks_count\": 8969,\n" +
            "            \"mirror_url\": null,\n" +
            "            \"open_issues_count\": 1288,\n" +
            "            \"forks\": 8969,\n" +
            "            \"open_issues\": 1288,\n" +
            "            \"watchers\": 25429,\n" +
            "            \"default_branch\": \"master\",\n" +
            "            \"score\": 1\n" +
            "        }";
}
