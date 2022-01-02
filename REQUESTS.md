# List of requests
HealthRequest (String)

## Alerts
ListUnreadAlertsRequest(SortOptions sortOptions) (Alert[])  
MarkUnreadAlertsAsReadRequest(boolean read) (Void)

## Conversations
ListUnreadConversationsRequest(SortOptions sortOptions) (Conversation[])  
StartConversationRequest(int recipientId, String title, String message) (Void)

## Conversation Replies
ListUnreadConversationRepliesRequest(int conversationId, SortOptions sortOptions) (Conversation[])  
ReplyToUnreadConversationRequest(int conversationId, String message) (Void)

## Members
ListBansRequest (Ban[])  
ModifyYourselfRequest(String customTitle, String aboutMe, String signature) (Void)  
RetrieveMemberByIDRequest(int memberId) (Member)  
RetrieveMemberByUsernameRequest(String username) (Member)  
RetrieveYourselfRequest (Member)

## Profile Posts
DeleteProfilePostRequest(int profilePostId) (Void)  
EditProfilePostRequest(int profilePostId, String message) (Void)  
ListProfilePostsRequest(SortOptions sortOptions) (ProfilePost[])  
RetrieveSpecificProfilePostRequest(int profilePostId) (ProfilePost)

## Resources
ListOwnedResourcesRequest(SortOptions sortOptions) (Resource[])  
ListPublicResourcesRequest(SortOptions sortOptions) (Resource[])  
ListCollaboratedResourcesRequest(SortOptions sortOptions) (Resource[])  
ModifyResourceRequest(int resourceId, String title, String tag_line, String description) (Void)  
RetrieveResourceRequest(int resourceId) (DetailedResource)

## Resource Downloads
ListResourceDownloadsByMemberRequest(int resourceId, int memberId, SortOptions sortOptions) (ResourceDownload[])  
ListResourceDownloadsByVersionRequest(int resourceId, int versionId, SortOptions sortOptions) (ResourceDownload[])  
ListResourceDownloadsRequest(int resourceId, SortOptions sortOptions) (ResourceDownload[])

## Resource Licenses
IssueResourceLicenseRequest(int resourceId, int purchaserId, long startDate, long endDate, boolean active, String siteUrl) (Void)  
ListResourceLicensesRequest(int resourceId, SortOptions sortOptions) (ResourceLicense[])  
ModifyResourceLicenseRequest(int resourceId, int licenseId, long startDate, long endDate, boolean active) (Void)  
RetrieveResourceLicenseRequest(int resourceId, int licenseId) (ResourceLicense)  
ValidateResourceLicenseRequest(int resourceId, int purchaserId, int nonce, long timestamp) (ResourceLicense)
RetrieveResourceLicenseByMemberRequest(int resourceId, int memberId, int nonce, long timestamp) (ResourceLicense)

## Resource Purchases
ListResourcePurchasesRequest(int resourceId, SortOptions sortOptions) (ResourcePurchase[])  
RetrieveResourcePurchaseRequest(int resourceId, int purchaseId) (ResourcePurchase)

## Resource Reviews
ListResourceReviewsRequest(int resourceId, SortOptions sortOptions) (ResourceReview[])  
RespondToResourceReviewRequest(int resourceId, int reviewId, String message) (Void)  
RetrieveMemberResourceReviewRequest(int resourceId, int memberId) (ResourceReview)

## Resource Updates
ListResourceUpdatesRequest(int resourceId, SortOptions sortOptions) (ResourceUpdate[])  
RetrieveLatestResourceUpdateRequest(int resourceId) (ResourceUpdate)  
RetrieveResourceUpdateRequest(int resourceId, int updateId) (ResourceUpdate)

## Resource Versions
ListResourceVersionsRequest(int resourceId, SortOptions sortOptions) (ResourceVersion[])  
RetrieveLatestResourceVersionRequest(int resourceId) (ResourceVersion)  
RetrieveResourceVersionRequest(int resourceId, int versionId) (ResourceVersion)

## Threads
FetchThreadRequest(int threadId) (DetailedThread)  
ListThreadsRequest(SortOptions sortOptions) (Thread[])

## Thread Replies
ListThreadRepliesRequest(int threadId, SortOptions sortOptions) (ThreadReply[])  
ReplyToThreadRequest(int threadId, String message) (Void)
