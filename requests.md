# List of requests
HealthRequest (String)

## Alerts
ListUnreadAlertsRequest (Alert[])  
MarkUnreadAlertsAsReadRequest(boolean read) (Void)

## Conversations
ListUnreadConversationsRequest (Conversation[])  
StartConversationRequest(int recipientId, String title, String message) (Void)

## Members
ListBansRequest (Ban[])  
ModifyYourselfRequest(String customTitle, String aboutMe, String signature) (Void)  
RetrieveMemberRequest(int memberId) (Member)  
RetrieveYourselfRequest (Member)

## Profile Posts
DeleteProfilePostRequest(int profilePostId) (Void)  
EditProfilePostRequest(int profilePostId, String message) (Void)  
ListProfilePostsRequest (ProfilePost[])  
RetrieveSpecificProfilePostRequest(int profilePostId) (ProfilePost)

## Resources
ListOwnedResourcesRequest (Resource[])  
ListPublicResourcesRequest (Resource[])  
ModifyResourceRequest(int resourceId, String title, String tag_line, String description) (Void)  
RetrieveResourceRequest(int resourceId) (DetailedResource)

## Resource Downloads
ListResourceDownloadsByMemberRequest(int resourceId, int memberId) (ResourceDownload[])  
ListResourceDownloadsByVersionRequest(int resourceId, int versionId) (ResourceDownload[])  
ListResourceDownloadsRequest(int resourceId) (ResourceDownload[])

## Resource Licenses
IssueResourceLicenseRequest(int resourceId, int purchaserId, long startDate, long endDate, boolean active, String siteUrl) (Void)  
ListResourceLicensesRequest(int resourceId) (ResourceLicense[])  
ModifyResourceLicenseRequest(int resourceId, int licenseId, long startDate, long endDate, boolean active) (Void)  
RetrieveResourceLicenseRequest(int resourceId, int licenseId) (ResourceLicense)  
ValidateResourceLicenseRequest(int resourceId, int purchaserId) (ResourceLicense)

## Resource Purchases
ListResourcePurchasesRequest(int resourceId) (ResourcePurchase[])  
RetrieveResourcePurchaseRequest(int resourceId, int purchaseId) (ResourcePurchase)

## Resource Reviews
ListResourceReviewsRequest(int resourceId) (ResourceReview[])  
RespondToResourceReviewRequest(int resourceId, int reviewId, String message) (Void)  
RetrieveMemberResourceReviewRequest(int resourceId, int memberId) (ResourceReview)

## Resource Updates
ListResourceUpdatesRequest(int resourceId) (ResourceUpdate[])  
RetrieveLatestResourceUpdateRequest(int resourceId) (ResourceUpdate)  
RetrieveResourceUpdateRequest(int resourceId, int updateId) (ResourceUpdate)

## Resource Versions
ListResourceVersionsRequest(int resourceId) (ResourceVersion[])  
RetrieveLatestResourceVersionRequest(int resourceId) (ResourceVersion)  
RetrieveResourceVersionRequest(int resourceId, int versionId) (ResourceVersion)

## Threads
FetchThreadRequest(int threadId) (DetailedThread)  
ListThreadsRequest (Thread[])

## Thread Replies
ListThreadRepliesRequest(int threadId) (ThreadReply[])  
ReplyToThreadRequest(int threadId, String message) (Void)
